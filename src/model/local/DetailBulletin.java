
package model.local;

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

  public float getAverage() {
    //TODO calc average
    return 0;
  }

  public DetailBulletin(int id, String appreciation, Enseignement enseignement, Bulletin bulletin) {
    this.id = id;
    this.appreciation = appreciation;
    this.enseignement = enseignement;
    this.bulletin = bulletin;
  }

  public int getId() {
    return id;
  }

  public String getAppreciation() {
    return appreciation;
  }

  public Enseignement getEnseignement() {
    return enseignement;
  }

  public Bulletin getBulletin() {
    return bulletin;
  }

  
  @Override
  public String toString() {
    return "DetailBulletin{" + "id=" + id + ", appreciation=" + appreciation + ", enseignement=" + enseignement + ", bulletin=" + bulletin + '}';
  }

  
}
