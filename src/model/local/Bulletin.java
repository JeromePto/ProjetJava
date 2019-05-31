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

  private Inscription insription;

  public Bulletin(int id, String appreciation, Trimestre trimestre, Inscription insription) {
    this.id = id;
    this.appreciation = appreciation;
    this.trimestre = trimestre;
    this.insription = insription;
  }

  @Override
  public String toString() {
    return "Bulletin{" + "id=" + id + ", appreciation=" + appreciation + ", trimestre=" + trimestre + ", insription=" + insription + '}';
  }

  /**
   * calculate the average
   *
   * @return Average for the bulletin
   */
  public float getAverage() {
    return 0; //TODO calc
  }

}
