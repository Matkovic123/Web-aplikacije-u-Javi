package hr.tvz.matkovic.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;

import hr.tvz.matkovic.db.jdbc.KorisnikRepository;
import hr.tvz.matkovic.domain.Korisnik;

public class KorisnikEditor extends PropertyEditorSupport {

	@Autowired
	private KorisnikRepository korisnikRepository;
	
	@Override
	public void setAsText(String text) {
		Korisnik k = null;
		for (Korisnik korisnik : korisnikRepository.findAll()) {
			if (korisnik.getKorisnickoIme().equals(text)) {
				k = korisnik;
				break;
			}
		}
		this.setValue(k);
	}

	@Override
	public String getAsText() {
		Korisnik k = (Korisnik) this.getValue();
		return (k != null ? k.getId().toString() : "");
	}

}
