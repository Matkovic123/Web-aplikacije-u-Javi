package hr.tvz.matkovic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hr.tvz.matkovic.domain.Biljeska;
import hr.tvz.matkovic.domain.Biljeznica;
import hr.tvz.matkovic.domain.Korisnik;
import hr.tvz.matkovic.models.MockHelper;
import hr.tvz.matkovic.models.NovaBiljeskaForm;

@Controller
public class NovaBiljeskaController {

	@GetMapping("/novaBiljeska")
	public String showForm(Model model) {
		model.addAttribute("korisniciList", MockHelper.mockKorisnikList());
		model.addAttribute("biljezniceList", MockHelper.mockBiljeznicaList());
		model.addAttribute("novaBiljeskaForm", new NovaBiljeskaForm());
		return "novaBiljeska";
	}

	@PostMapping("/novaBiljeska")
	public String processForm(@ModelAttribute NovaBiljeskaForm novaBiljeskaForm, Model model) {
		Korisnik biljeskaKorisnik = null;
		Biljeznica biljeskaBiljeznica = null;
		
		for (Korisnik korisnik : MockHelper.mockKorisnikList()) {
			if (korisnik.getId().equals(Long.parseLong(novaBiljeskaForm.getKorisnikId()))) {
				biljeskaKorisnik = korisnik;
				break;
			}
		}
		
		for (Biljeznica biljeznica : MockHelper.mockBiljeznicaList()) {
			if (biljeznica.getId().equals(Long.parseLong(novaBiljeskaForm.getBiljeznicaId()))) {
				biljeskaBiljeznica = biljeznica;
				break;
			}
		}
		
		Biljeska biljeska  = new Biljeska(novaBiljeskaForm.getNaslov(), novaBiljeskaForm.getTekst(), 
				biljeskaKorisnik, biljeskaBiljeznica);
		
		model.addAttribute("biljeska", biljeska);
		
		return "unesenaBiljeska";
	}
}
