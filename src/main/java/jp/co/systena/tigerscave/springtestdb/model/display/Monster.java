package jp.co.systena.tigerscave.springtestdb.model.display;

public abstract class Monster {
  // 敵クラス

  private int hp;
  private String name;
  private String knockedDownMessage;
  private String attackMessage;
  private int attackPower;

  public abstract void takeDamage(int damageQuantity);

  public abstract void fight(String opponentName, int attackPower);

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getKnockedDownMessage() {
    return knockedDownMessage;
  }

  public void setKnockedDownMessage(String knockedDownMessage) {
    this.knockedDownMessage = knockedDownMessage;
  }

  public String getAttackMessage() {
    return attackMessage;
  }

  public void setAttackMessage(String attackMessage) {
    this.attackMessage = attackMessage;
  }

  public int getAttackPower() {
    return attackPower;
  }

  public void setAttackPower(int attackPower) {
    this.attackPower = attackPower;
  }
}
