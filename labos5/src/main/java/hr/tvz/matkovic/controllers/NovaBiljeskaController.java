package hr.tvz.matkovic.controllers;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import hr.tvz.matkovic.db.jdbc.BiljeskaRepository;
import hr.tvz.matkovic.db.jdbc.BiljeznicaRepository;
import hr.tvz.matkovic.db.jdbc.KorisnikRepository;
import hr.tvz.matkovic.domain.Biljeska;
import hr.tvz.matkovic.domain.Biljeznica;
import hr.tvz.matkovic.domain.Korisnik;
import hr.tvz.matkovic.editors.BiljeznicaEditor;
import hr.tvz.matkovic.editors.KorisnikEditor;
import hr.tvz.matkovic.models.NovaBiljeskaForm;

@Controller
@SessionAttributes(names = {"biljeskaBrojac","novaBiljeskaForm"})
public class NovaBiljeskaController {
	
	@Autowired
	private BiljeznicaRepository biljeznicaRepository;	
	@Autowired
	private KorisnikRepository korisnikRepository;
	@Autowired
	private BiljeskaRepository biljeskaRepository;

	@ModelAttribute("novaBiljeskaForm")
	public NovaBiljeskaForm getBiljeska() {
		return new NovaBiljeskaForm();
	}

	@ModelAttribute("biljeskaBrojac")
	public Map<Integer, String> getBiljeskaBrojac() {
		return new HashMap<>();
	}
	
	@InitBinder
	public void dataBinding(WebDataBinder binder){		
		binder.registerCustomEditor(Korisnik.class,new KorisnikEditor());
		binder.registerCustomEditor(Biljeznica.class, new BiljeznicaEditor());
	}	
	
	@GetMapping("/editBiljeska")
	public String edit(@SessionAttribute NovaBiljeskaForm novaBiljeskaForm, Model model){
		model.addAttribute("novaBiljeskaForm", novaBiljeskaForm);
		return "redirect:/novaBiljeska";
	}
	
	
	@GetMapping("/novaBiljeska")
	public String showForm(Model model) {
		model.addAttribute("korisniciList",korisnikRepository.findAll());
		model.addAttribute("biljezniceList",biljeznicaRepository.findAll());
		return "novaBiljeska";
	}		
	//sprema podatke za međukorak
	@PostMapping("/novaBiljeska")
	public String novaBiljeska(@ModelAttribute NovaBiljeskaForm novaBiljeskaForm, Model model, Principal principal) {
		if(novaBiljeskaForm.getKorisnik() == null){
			novaBiljeskaForm.setKorisnik(korisnikRepository.findAll().stream().filter(korisnik->korisnik.getIme().equals(principal.getName())).findFirst().get());
		}		
		model.addAttribute("korisnickoIme", novaBiljeskaForm.getKorisnik().getKorisnickoIme());		
		model.addAttribute("biljeznicaIme", novaBiljeskaForm.getBiljeznica().getNaziv());
		return "pregledBiljeske";
	}
	
	

	@GetMapping("/spremiBiljesku")
	public String spremiBiljesku(@SessionAttribute NovaBiljeskaForm novaBiljeskaForm,
			@SessionAttribute Map<String, Integer> biljeskaBrojac, Model model) {
		
		Biljeska biljeska = new Biljeska(novaBiljeskaForm.getNaslov(), novaBiljeskaForm.getTekst(),novaBiljeskaForm.getKorisnik(),novaBiljeskaForm.getBiljeznica());				
		
		model.addAttribute("biljeska",biljeska);
		
		if (biljeskaBrojac.containsKey(novaBiljeskaForm.getBiljeznica().getNaziv())) {
			int i = biljeskaBrojac.get(novaBiljeskaForm.getBiljeznica().getNaziv());
			i++;
			biljeskaBrojac.put(novaBiljeskaForm.getBiljeznica().getNaziv(),i);
		} else {
			biljeskaBrojac.put(novaBiljeskaForm.getBiljeznica().getNaziv(), 1);
		}

		return "unesenaBiljeska";
	}

	@GetMapping("/novaBiljeskaResetiraj")
	public String showFormFresh(SessionStatus status) {
		status.setComplete();
		return "redirect:/novaBiljeska";
	}
}

























