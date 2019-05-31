
package model.local;

import java.util.List;

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

  private List<Enseignement> enseignements;

  public Discipline() {
  }

  public Discipline(int id, String nom, List<Enseignement> enseignements) {
    this.id = id;
    this.nom = nom;
    this.enseignements = enseignements;
  }

  
}
