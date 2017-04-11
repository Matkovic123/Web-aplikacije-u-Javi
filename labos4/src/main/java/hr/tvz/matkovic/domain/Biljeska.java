package hr.tvz.matkovic.domain;

public class Biljeska {

	private String naslov;
	private String tekst;
	private Korisnik korisnik;
	private Biljeznica biljeznica;

	public Biljeska( Korisnik korisnik, Biljeznica biljeznica, String naslov, String tekst) {
		super();
		this.naslov = naslov;
		this.tekst = tekst;
		this.korisnik = korisnik;
		this.biljeznica = biljeznica;
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

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Biljeznica getBiljeznica() {
		return biljeznica;
	}

	public void setBiljeznica(Biljeznica biljeznica) {
		this.biljeznica = biljeznica;
	}
	
	

}
