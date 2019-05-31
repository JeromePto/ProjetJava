
package model.local;

import java.util.List;

/**
 * 
 * @author Jerome
 */
public class Classe {
  /**
   * Classe ID
   */
  private int id;

  /**
   * name of classe
   */
  private String nom;

  private AnneeScolaire anneeScolaire;

  private Niveau niveau;

  private List<Inscription> inscriptions;

  private List<Enseignement> enseignements;

  public Classe() {
  }

  public Classe(int id, String nom, AnneeScolaire anneeScolaire, Niveau niveau, List<Inscription> inscriptions, List<Enseignement> enseignements) {
    this.id = id;
    this.nom = nom;
    this.anneeScolaire = anneeScolaire;
    this.niveau = niveau;
    this.inscriptions = inscriptions;
    this.enseignements = enseignements;
  }
  
  
}
