package jp.co.systena.tigerscave.springtestdb.model.display;

public class Monk extends Job {

  @Override
  public String fight() {
    return "拳で攻撃した！";
  }

  @Override
  public String heal() {
    return "やくそうで回復した！";
  }
}
