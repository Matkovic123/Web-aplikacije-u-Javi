package hr.tvz.matkovic.models;
import java.util.ArrayList;
import java.util.List;

import hr.tvz.matkovic.domain.Biljeznica;
import hr.tvz.matkovic.domain.Korisnik;

public class MockHelper {

	
	public static List<Korisnik> mockKorisnikList(){
		List<Korisnik> korisnikList = new ArrayList<>();
		korisnikList.add(new Korisnik((long)1, "AlienInvader", "Izdislav", "Šveljko"));
		korisnikList.add(new Korisnik((long)2, "Onix", "Ash", "Ketchum"));
		korisnikList.add(new Korisnik((long)3, "Sweepy", "Marko", "Marulić"));
		return korisnikList;	
	}

	public static List<Biljeznica> mockBiljeznicaList() {
		List<Biljeznica>biljeznicaList = new ArrayList<>();
		biljeznicaList.add(new Biljeznica((long)1, "Thymeleaf","Frontend stuff"));
		biljeznicaList.add(new Biljeznica((long)2, "Hibernate","Database stuff"));
		biljeznicaList.add(new Biljeznica((long)3, "Bootstrap","CSS stuff"));
		return biljeznicaList;
	}
	
	
	
}
	