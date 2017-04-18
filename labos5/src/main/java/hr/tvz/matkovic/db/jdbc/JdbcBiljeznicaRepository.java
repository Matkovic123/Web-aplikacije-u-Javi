package hr.tvz.matkovic.db.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import hr.tvz.matkovic.domain.Biljeznica;

public class JdbcBiljeznicaRepository implements BiljeznicaRepository{

	private JdbcTemplate jdbcTemplate;

	public JdbcBiljeznicaRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Biljeznica> findAll() {
		return jdbcTemplate.query("select naziv, opis from biljeznica", new BiljeznicaRowMapper());
	}

	@Override
	public Biljeznica findOne(String naziv) {
	return
	jdbcTemplate.queryForObject("select naziv, opis from biljeznica where naziv=?",
	new BiljeznicaRowMapper(), naziv);
	}

	private static final class BiljeznicaRowMapper implements RowMapper<Biljeznica> {
		public Biljeznica mapRow(ResultSet rs, int rowNum) throws SQLException {
			String naziv = rs.getString("naziv");
			String opis = rs.getString("opis");
			return new Biljeznica(naziv, opis);
		}
	}
}
