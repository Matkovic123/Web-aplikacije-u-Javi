package hr.tvz.matkovic.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;

import hr.tvz.matkovic.db.jdbc.BiljeznicaRepository;
import hr.tvz.matkovic.domain.Biljeznica;

public class BiljeznicaEditor extends PropertyEditorSupport {
	
	@Autowired
	private BiljeznicaRepository biljeznicaRepository;	

	@Override
	public void setAsText(String text) {
		Biljeznica b = null;
		for (Biljeznica biljeznica : biljeznicaRepository.findAll()) {
			if (biljeznica.getId().equals(Long.parseLong(text))) {
				b = biljeznica;
				break;
			}
		}
		this.setValue(b);
	}

	@Override
	public String getAsText() {
		Biljeznica b = (Biljeznica) this.getValue();
		return (b != null ? b.getId().toString() : "");
	}
}
