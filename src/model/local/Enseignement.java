
package model.local;

import java.util.List;

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

  private List<DetailBulletin> detailBulletins;

  public Enseignement() {
  }

  public Enseignement(int id, Classe classe, Discipline discipline, Professeur professeur, List<DetailBulletin> detailBulletins) {
    this.id = id;
    this.classe = classe;
    this.discipline = discipline;
    this.professeur = professeur;
    this.detailBulletins = detailBulletins;
  }
  
}
