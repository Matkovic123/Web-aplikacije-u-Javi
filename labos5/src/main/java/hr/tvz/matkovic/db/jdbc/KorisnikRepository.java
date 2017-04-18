package hr.tvz.matkovic.db.jdbc;

import java.util.List;

import hr.tvz.matkovic.domain.Korisnik;

public interface KorisnikRepository {

	Korisnik findOne(String username);

	List<Korisnik> findAll();

}
