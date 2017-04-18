package hr.tvz.matkovic.db.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import hr.tvz.matkovic.domain.Biljeska;
import hr.tvz.matkovic.domain.Biljeznica;
import hr.tvz.matkovic.domain.Korisnik;

public class JdbcBiljeskaRepository implements BiljeskaRepository{
	
	private JdbcTemplate jdbcTemplate;

	public JdbcBiljeskaRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Biljeska> findAll() {
		return jdbcTemplate.query("select naslov, tekst, korisnik, biljeznica from biljeska", new BiljeskaRowMapper());
	}

	@Override
	public Biljeska findOne(String naslov) {
	return
	jdbcTemplate.queryForObject("select naslov, tekst, korisnik, biljeznica from biljeska where naslov=?",
	new BiljeskaRowMapper(), naslov);
	}

	private static final class BiljeskaRowMapper implements RowMapper<Biljeska> {
		@Autowired
		private BiljeznicaRepository biljeznicaRepository;	
		@Autowired
		private KorisnikRepository korisnikRepository;

		public Biljeska mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			String naslov = rs.getString("naslov");
			String tekst = rs.getString("tekst");
			
			Korisnik korisnik = korisnikRepository.findOne(rs.getString("korisnik"));
			Biljeznica biljeznica = biljeznicaRepository.findOne(rs.getString("biljeznica"));
			
			return new Biljeska(naslov, tekst, korisnik, biljeznica);
		}
	}

}
