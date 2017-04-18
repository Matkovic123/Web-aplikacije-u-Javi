package hr.tvz.matkovic.models;

import hr.tvz.matkovic.domain.Biljeznica;
import hr.tvz.matkovic.domain.Korisnik;

public class NovaBiljeskaForm {	
	private Biljeznica biljeznica;
	private Korisnik korisnik;
	private String naslov;
	private String tekst;
	

	public Biljeznica getBiljeznica() {
		return biljeznica;
	}
	public void setBiljeznica(Biljeznica biljeznica) {
		this.biljeznica = biljeznica;
	}
	public Korisnik getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	public String getNaslov() {
		return naslov;
	}
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}
	public String getTekst() {
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}	

	
}
