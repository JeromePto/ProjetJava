
package model.local;

/**
 * 
 * 
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

  /**
   * calculate the average
   * @return Average for the bulletin
   */
  public float getAverage() {
  }

}
