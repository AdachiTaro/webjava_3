package jp.co.systena.tigerscave.springtestdb.model.display;

public class Warrior extends Job {
  // 戦士クラス
  @Override
  public String fight() {
    return "剣で攻撃した！";
  }

  @Override
  public String heal() {
    return "やくそうで回復した！";
  }
}
