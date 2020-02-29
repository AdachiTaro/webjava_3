package jp.co.systena.tigerscave.springtestdb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import jp.co.systena.tigerscave.springtestdb.model.display.Party;

@Service
public class DbAccessService {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  public List<Party> getPartyMembers() {
    List<Party> party = jdbcTemplate.query("SELECT * FROM characters ORDER BY character_id",
        new BeanPropertyRowMapper<Party>(Party.class));
    return party;
  }

  public void addCharacter(String name, int jobId, int DEFAULT_HP) {
    jdbcTemplate.update(
        "INSERT INTO characters(character_name, character_job_id, default_hp) VALUES(?, ?, ?)",
        name,
        jobId,
        DEFAULT_HP
    );
  }
}
