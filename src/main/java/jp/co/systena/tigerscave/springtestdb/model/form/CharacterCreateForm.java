package jp.co.systena.tigerscave.springtestdb.model.form;

public class CharacterCreateForm {
  // キャラクター作成フォーム
  private String job;
  private String name;

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
