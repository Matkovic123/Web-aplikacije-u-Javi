package hr.tvz.matkovic.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import hr.tvz.matkovic.domain.Biljeska;
import hr.tvz.matkovic.domain.Biljeznica;
import hr.tvz.matkovic.domain.Korisnik;
import hr.tvz.matkovic.models.MockHelper;
import hr.tvz.matkovic.models.NovaBiljeskaForm;

@Controller
@SessionAttributes(names = {"biljeskaBrojac","novaBiljeskaForm"})
public class NovaBiljeskaController {

	@ModelAttribute("novaBiljeskaForm")
	public NovaBiljeskaForm getBiljeska() {
		return new NovaBiljeskaForm();
	}

	@ModelAttribute("biljeskaBrojac")
	public Map<Integer, String> getBiljeskaBrojac() {
		return new HashMap<>();
	}
	
	@GetMapping("/editBiljeska")
	public String edit(@SessionAttribute NovaBiljeskaForm novaBiljeskaForm, Model model){
		model.addAttribute("novaBiljeskaForm", novaBiljeskaForm);
		return "redirect:/novaBiljeska";
	}
	
	
	@GetMapping("/novaBiljeska")
	public String showForm(Model model) {
		model.addAttribute("korisniciList", MockHelper.mockKorisnikList());
		model.addAttribute("biljezniceList", MockHelper.mockBiljeznicaList());
		return "novaBiljeska";
	}		
	//sprema podatke za meðukorak
	@PostMapping("/novaBiljeska")
	public String novaBiljeska(@ModelAttribute NovaBiljeskaForm novaBiljeskaForm, Model model) {
		model.addAttribute("korisnickoIme",MockHelper.mockKorisnikList().stream().filter(korisnik-> korisnik.getId().equals(Long.parseLong(novaBiljeskaForm.getKorisnikId()))).findFirst().get().getPunoIme());
		model.addAttribute("biljeznicaIme", MockHelper.mockBiljeznicaList().stream().filter(biljeznica -> biljeznica.getId().equals(Long.parseLong(novaBiljeskaForm.getBiljeznicaId()))).findFirst().get().getNaziv());		
		return "pregledBiljeske";
	}
	
	

	@GetMapping("/spremiBiljesku")
	public String spremiBiljesku(@SessionAttribute NovaBiljeskaForm novaBiljeskaForm,
			@SessionAttribute Map<String, Integer> biljeskaBrojac, Model model) {

		List<Korisnik> korisnici = MockHelper.mockKorisnikList();
		List<Biljeznica> biljeznice = MockHelper.mockBiljeznicaList();
		Korisnik korisnik;
		Biljeznica biljeznica;
		if (novaBiljeskaForm.getKorisnikId().equals("null"))
			korisnik = null;
		else {
			korisnik = korisnici.stream()
					.filter(x -> x.getId().equals(Long.parseLong(novaBiljeskaForm.getKorisnikId()))).findFirst().get();
		}
		if (novaBiljeskaForm.getBiljeznicaId().equals("null")) {
			biljeznica = null;
		} else {
			biljeznica = biljeznice.stream()
					.filter(bilj -> bilj.getId().equals(Long.parseLong(novaBiljeskaForm.getBiljeznicaId()))).findFirst()
					.get();
		}
		Biljeska biljeska = new Biljeska(novaBiljeskaForm.getNaslov(),novaBiljeskaForm.getTekst(),korisnik,biljeznica);
		model.addAttribute("biljeska",biljeska);
		
		if (biljeskaBrojac.containsKey(biljeznica.getNaziv())) {
			int i = biljeskaBrojac.get(biljeznica.getNaziv());
			i++;
			biljeskaBrojac.put(biljeznica.getNaziv(),i);
		} else {
			biljeskaBrojac.put(biljeznica.getNaziv(), 1);
		}

		return "unesenaBiljeska";
	}

	@GetMapping("/novaBiljeskaResetiraj")
	public String showFormFresh(SessionStatus status) {
		status.setComplete();
		return "redirect:/novaBiljeska";
	}
}
