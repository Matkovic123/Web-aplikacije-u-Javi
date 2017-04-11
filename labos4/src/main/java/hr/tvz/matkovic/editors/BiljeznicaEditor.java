package hr.tvz.matkovic.editors;

import java.beans.PropertyEditorSupport;
import hr.tvz.matkovic.domain.Biljeznica;
import hr.tvz.matkovic.models.MockHelper;

public class BiljeznicaEditor extends PropertyEditorSupport {
	
	@Override
	public void setAsText(String text) {
		Biljeznica b = null;
		for (Biljeznica biljeznica : MockHelper.mockBiljeznicaList()) {
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
