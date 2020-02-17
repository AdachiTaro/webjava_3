package jp.co.systena.tigerscave.springtestdb.model.display;

import java.util.ArrayList;
import java.util.List;

public class Party {
  private List<Character> partyList = new ArrayList<Character>();

  public void addPartyMember(Character createdCharacter) {
    partyList.add(createdCharacter);
  }

  public void setPartyList(List<Character> partyList) {
    this.partyList = partyList;
  }

  public List<Character> getPartyList() {
    return partyList;
  }
}
