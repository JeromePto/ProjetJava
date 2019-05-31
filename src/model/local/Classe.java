
package model.local;


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

  public Classe(int id, String nom, AnneeScolaire anneeScolaire, Niveau niveau) {
    this.id = id;
    this.nom = nom;
    this.anneeScolaire = anneeScolaire;
    this.niveau = niveau;
  }

  @Override
  public String toString() {
    return "Classe{" + "id=" + id + ", nom=" + nom + ", anneeScolaire=" + anneeScolaire + ", niveau=" + niveau + '}';
  }
  
  
}
