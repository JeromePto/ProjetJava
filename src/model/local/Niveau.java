
package model.local;

/**
 * 
 * @author Jerome
 */
public class Niveau {
  /**
   * Niveau ID
   */
  private int id;
  
  private String nom;

  public Niveau() {
  }

  public Niveau(int id, String nom) {
    this.id = id;
    this.nom = nom;
  }

  public int getId() {
    return id;
  }

  public String getNom() {
    return nom;
  }

  @Override
  public String toString() {
    return "Niveau{" + "id=" + id + ", nom=" + nom + '}';
  }
  
}
