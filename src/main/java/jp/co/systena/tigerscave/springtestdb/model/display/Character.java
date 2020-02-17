package jp.co.systena.tigerscave.springtestdb.model.display;

public class Character {
  private int characterId;
  private String jobName;
  private int hp;
  private Job job;
  private String name;
  private String command;
  private int commandId;

  public final int COMMAND_FIGHT = 0;
  public final int COMMAND_HEAL = 1;

  public Character(int id, String jobname, int hp, String name) {
    switch (jobname) {
      case "戦士":
        setJob(new Warrior());
        break;
      case "魔法使い":
        setJob(new Wizard());
        break;
      case "武闘家":
        setJob(new Monk());
        break;
    }
    setCharacterId(id);
    setJobName(jobname);
    setHp(hp);
    setName(name);
    if (getCommand() == null) {
      setCommand("未選択");
    }
  }

  public int getCharacterId() {
    return characterId;
  }

  public void setCharacterId(int characterId) {
    this.characterId = characterId;
  }

  public String getJobName() {
    return jobName;
  }

  public void setJobName(String jobName) {
    this.jobName = jobName;
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public Job getJob() {
    return job;
  }

  public void setJob(Job job) {
    this.job = job;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCommand() {
    return command;
  }

  public void setCommand(String command) {
    this.command = command;
  }

  public int getCommandId() {
    return commandId;
  }

  public void setCommandId(int commandId) {
    this.commandId = commandId;
  }

  public void executeHeal() {
    int remainingHP = getHp();

    switch (getJobName()) {
      case "魔法使い":
        remainingHP += 20;
        break;
      default:
        remainingHP += 10;
    }

    setHp(remainingHP);
  }
}
