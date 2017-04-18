package hr.tvz.matkovic.db.jdbc;

import java.util.List;

import hr.tvz.matkovic.domain.Biljeznica;

public interface BiljeznicaRepository {

	 List<Biljeznica> findAll();

	 Biljeznica findOne(String naziv);

}
