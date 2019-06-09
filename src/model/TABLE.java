/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * classe de constante qui permet d'assigner des ID et des noms au tables
 * 
 */
public class TABLE {
  
  public final static int ANNEESCOLAIRE = 0;
  public final static int BULLETIN = 1;
  public final static int CLASSE = 2;
  public final static int DETAILBULLETIN = 3;
  public final static int DISCIPLINE = 4;
  public final static int ELEVE = 5;
  public final static int ENSEIGNEMENT = 6;
  public final static int EVALUATION = 7;
  public final static int INSCRIPTION = 8;
  public final static int NIVEAU = 9;
  public final static int PROFESSEUR = 10;
  public final static int TRIMESTRE = 11;
  /**
   * modifie les noms des tables 
   * @param id
   * @return 
   */
  public final static String name(int id) {
    switch (id) {
      case TABLE.ANNEESCOLAIRE: 
        return "Année scolaire";
      case TABLE.BULLETIN:
        return "Bulletin";
      case TABLE.CLASSE:
        return "Classe";
      case TABLE.DETAILBULLETIN:
        return "Detail bulletin";
      case TABLE.DISCIPLINE:
        return "Discipline";
      case TABLE.ELEVE:
        return "Eleve";
      case TABLE.ENSEIGNEMENT:
        return "Enseignement";
      case TABLE.EVALUATION:
        return "Evaluation";
      case TABLE.INSCRIPTION:
        return "Inscription";
      case TABLE.NIVEAU:
        return "Niveau";
      case TABLE.PROFESSEUR:
        return "Professeur";
      case TABLE.TRIMESTRE:
        return "Trimestre";
      default:
        throw new RuntimeException("Internal error");
    }
  }
  
}
