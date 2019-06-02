
package model.local;

/**
 * 
 * @author Jerome
 */
public class Enseignement {
  /**
   * Enseignement ID
   */
  private int id;

  private Classe classe;

  private Discipline discipline;

  private Professeur professeur;

  public Enseignement() {
  }

  public Enseignement(int id, Classe classe, Discipline discipline, Professeur professeur) {
    this.id = id;
    this.classe = classe;
    this.discipline = discipline;
    this.professeur = professeur;
  }

  @Override
  public String toString() {
    return "Enseignement{" + "id=" + id + ", classe=" + classe + ", discipline=" + discipline + ", professeur=" + professeur + '}';
  }
  
}
