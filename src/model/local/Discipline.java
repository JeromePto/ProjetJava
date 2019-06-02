
package model.local;

/**
 * 
 * @author Jerome
 */
public class Discipline {
  /**
   * Discipline ID
   */
  private int id;

  /**
   * Discipline name
   */
  private String nom;

  public Discipline(int id, String nom) {
    this.id = id;
    this.nom = nom;
  }

  @Override
  public String toString() {
    return "Discipline{" + "id=" + id + ", nom=" + nom + '}';
  }

  
}
