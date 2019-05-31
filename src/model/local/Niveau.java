
package model.local;

import java.util.List;

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

  private List<Classe> classes;

  public Niveau() {
  }

  public Niveau(int id, String nom, List<Classe> classes) {
    this.id = id;
    this.nom = nom;
    this.classes = classes;
  }

  @Override
  public String toString() {
    return "Niveau{" + "id=" + id + ", nom=" + nom + ", classes=" + classes + '}';
  }
  
  
}
