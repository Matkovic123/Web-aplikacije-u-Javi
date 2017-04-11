package hr.tvz.matkovic.editors;

import java.beans.PropertyEditorSupport;
import hr.tvz.matkovic.domain.Korisnik;
import hr.tvz.matkovic.models.MockHelper;

public class KorisnikEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) {
		Korisnik k = null;
		for (Korisnik korisnik : MockHelper.mockKorisnikList()) {
			if (korisnik.getId().equals(Long.parseLong(text))) {
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
