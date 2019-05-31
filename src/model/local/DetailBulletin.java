
package model.local;

import java.util.List;

/**
 * 
 * @author Jerome
 */
public class DetailBulletin {
  /**
   * DetailBulletin ID
   */
  private int id;

  /**
   * DetailBulletin appreciation
   */
  private String appreciation;

  private Enseignement enseignement;

  private Bulletin bulletin;

  private List<Evaluation> evaluation;

  public float getAverage() {
    for(Evaluation it : evaluation) {
      
    }
    return 0;
  }

  public DetailBulletin() {
  }

  public DetailBulletin(int id, String appreciation, Enseignement enseignement, Bulletin bulletin, List<Evaluation> evaluation) {
    this.id = id;
    this.appreciation = appreciation;
    this.enseignement = enseignement;
    this.bulletin = bulletin;
    this.evaluation = evaluation;
  }

  
}
