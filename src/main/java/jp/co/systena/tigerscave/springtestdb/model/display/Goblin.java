package jp.co.systena.tigerscave.springtestdb.model.display;

public class Goblin extends Monster {
  private final int DEFAULT_HP = 100;
  private final int DEFAULT_ATTACK_POWER = 10;

  public Goblin(String name) {
    setHp(DEFAULT_HP);
    setName(name);
    setKnockedDownMessage(name + "は倒れた！");
    setAttackPower(DEFAULT_ATTACK_POWER);
  }

  @Override
  public void takeDamage(int damageQuantity) {
    int remainingHP = getHp();

    remainingHP -= damageQuantity;

    if (remainingHP < 0) {
      remainingHP = 0;
    }

    setHp(remainingHP);
  }

  @Override
  public void fight(String opponentName, int attackPower) {
    if (attackPower != 0) {
      setAttackMessage(getName() + "は" + opponentName + "に" + attackPower + "ダメージを与えた！");
    } else {
      setAttackMessage(getName() + "の攻撃は外れた！");
    }
  }
}
