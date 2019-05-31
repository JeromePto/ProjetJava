package model.local;

/**
 *
 * @author Jerome
 */
public abstract class Personne {

  /**
   * Peronne ID
   */
  protected int id;

  /**
   * Personne Name
   */
  protected String nom;

  /**
   * Surname Personne
   */
  protected String Prenom;

  public Personne() {
  }

  public Personne(int id, String nom, String Prenom) {
    this.id = id;
    this.nom = nom;
    this.Prenom = Prenom;
  }

  public abstract boolean isEleve();
  /**
   * is it an Eleve
   *
   * @return true if is an eleve
   */

}
