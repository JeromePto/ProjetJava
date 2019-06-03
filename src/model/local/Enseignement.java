
package model.local;

import java.util.LinkedHashSet;
import java.util.Set;

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
    String tmp = "";
    for(String it : getInfo()) {
      tmp += it + " ";
    }
    return printId ? String.valueOf(id) + " : " + tmp : tmp;
  }

  Set<String> getInfo() {
    Set<String> out = new LinkedHashSet<>();
    out.addAll(discipline.getInfo());
    out.addAll(classe.getInfo());
    out.addAll(professeur.getInfo());
    return out;
  }
  
  @Override
  public String toString() {
    return "Enseignement{" + "id=" + id + ", classe=" + classe + ", discipline=" + discipline + ", professeur=" + professeur + '}';
  }
  
}
