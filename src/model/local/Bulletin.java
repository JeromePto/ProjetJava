
package model.local;

import java.util.List;

/**
 * 
 * @author Jerome
 */
public class Bulletin {
  /**
   * Bulletin ID
   */
  private int id;

  /**
   * Bulletin appreciation
   */
  private String appreciation;

  private Trimestre trimestre;

  private Inscription insription;

  private List<DetailBulletin> detailBulletins;

  public Bulletin() {
  }

  public Bulletin(int id, String appreciation, Trimestre trimestre, Inscription insription, List<DetailBulletin> detailBulletins) {
    this.id = id;
    this.appreciation = appreciation;
    this.trimestre = trimestre;
    this.insription = insription;
    this.detailBulletins = detailBulletins;
  }
  
  /**
   * calculate the average
   * @return Average for the bulletin
   */
  public float getAverage() {
    return 0;
  }

}
