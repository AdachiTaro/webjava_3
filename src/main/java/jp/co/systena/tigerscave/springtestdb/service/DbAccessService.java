package jp.co.systena.tigerscave.springtestdb.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import jp.co.systena.tigerscave.springtestdb.model.display.Character;
import jp.co.systena.tigerscave.springtestdb.model.display.Party;

@Service
public class DbAccessService {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  public Party getPartyMembers() {
    Party party = createParty();

    return party;
  }

  private Party createParty() {
    Party party = new Party();
    // charactersテーブルに格納されている値とjob名を結び付けて取得
    String sql = "SELECT * FROM characters " + "INNER JOIN jobs "
        + "ON characters.character_job_id = jobs.job_id " + "ORDER BY character_id";
    List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);

    // listの中身をコンソールへ出力
    // list.forEach(System.out::println);

    // DBから取り出した値でCharacterクラスのオブジェクトを生成してPartyクラスにadd
    for (Map<String, Object> m : list) {
      int id = (int) m.get("character_id");
      String name = (String) m.get("character_name");
      String jobName = (String) m.get("job_name");
      int defaultHp = (int) m.get("default_hp");

      Character c = new Character(id, jobName, defaultHp, name);
      party.addPartyMember(c);
    }

    return party;
  }


  // テーブルにキャラクターを登録する
  public void addCharacter(String name, int jobId, int DEFAULT_HP) {
    jdbcTemplate.update(
        "INSERT INTO characters(character_name, character_job_id, default_hp) VALUES(?, ?, ?)",
        name, jobId, DEFAULT_HP);
  }

  // テーブルから選んだキャラクターIDのキャラを削除する
  public void deleteCharacter(String characterId) {
    String sql = "DELETE FROM characters WHERE character_id = ? ";
    jdbcTemplate.update(sql, Integer.parseInt(characterId));
  }
}
