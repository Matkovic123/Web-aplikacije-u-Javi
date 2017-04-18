package hr.tvz.matkovic.db.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import hr.tvz.matkovic.domain.Korisnik;

public class JdbcKorisnikRepository implements KorisnikRepository {
	
	private JdbcTemplate jdbcTemplate;

	public JdbcKorisnikRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Korisnik> findAll() {
		return jdbcTemplate.query("select id, ime, prezime, username from user", new KorisnikRowMapper());
	}

	@Override
	public Korisnik findOne(String korisnickoIme) {
	return jdbcTemplate.queryForObject("select id, ime, prezime, username from user where username=?",	new KorisnikRowMapper(), korisnickoIme);
	}

	private static final class KorisnikRowMapper implements RowMapper<Korisnik> {
		public Korisnik mapRow(ResultSet rs, int rowNum) throws SQLException {
			Long id = rs.getLong("id");
			String ime = rs.getString("ime");
			String prezime = rs.getString("prezime");
			String korisnickoIme = rs.getString("username");
			return new Korisnik(id,ime, prezime, korisnickoIme);
		}
	}

}
