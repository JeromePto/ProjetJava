
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

  public int getId() {
    return id;
  }

  public Classe getClasse() {
    return classe;
  }

  public Discipline getDiscipline() {
    return discipline;
  }

  public Professeur getProfesseur() {
    return professeur;
  }

  public Enseignement(int id, Classe classe, Discipline discipline, Professeur professeur) {
    this.id = id;
    this.classe = classe;
    this.discipline = discipline;
    this.professeur = professeur;
  }
  
  public String readId(boolean printId) {
    String tmp = discipline.readId(false) + " " + classe.readId(false) + " " + professeur.readId(false);
    return printId ? String.valueOf(id) + " : " + tmp : tmp;
  }

  @Override
  public String toString() {
    return "Enseignement{" + "id=" + id + ", classe=" + classe + ", discipline=" + discipline + ", professeur=" + professeur + '}';
  }
  
}
