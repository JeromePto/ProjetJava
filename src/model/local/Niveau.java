
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
  
  public String readId(boolean printId) {
    String tmp = nom;
    return printId ? String.valueOf(id) + " : " + tmp : tmp;
  }

  @Override
  public String toString() {
    return "Niveau{" + "id=" + id + ", nom=" + nom + '}';
  }
  
}
