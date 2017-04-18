package hr.tvz.matkovic.db.jdbc;

import java.util.List;

import hr.tvz.matkovic.domain.Biljeska;

public interface BiljeskaRepository {

	 List<Biljeska> findAll();

	 Biljeska findOne(String naslov);

}
