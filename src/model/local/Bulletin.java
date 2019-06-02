package model.local;

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

  private Inscription inscription;

  public Bulletin(int id, String appreciation, Trimestre trimestre, Inscription inscription) {
    this.id = id;
    this.appreciation = appreciation;
    this.trimestre = trimestre;
    this.inscription = inscription;
  }

  @Override
  public String toString() {
    return "Bulletin{" + "id=" + id + ", appreciation=" + appreciation + ", trimestre=" + trimestre + ", insription=" + inscription + '}';
  }

  /**
   * calculate the average
   *
   * @return Average for the bulletin
   */
  public float getAverage() {
    return 0; //TODO calc
  }

  public int getId() {
    return id;
  }

  public String getAppreciation() {
    return appreciation;
  }

  public Trimestre getTrimestre() {
    return trimestre;
  }

  public Inscription getInscription() {
    return inscription;
  }

}
