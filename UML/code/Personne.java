
package model.local;

/**
 * 
 * 
 */
public abstract class Personne {
  /**
   * Peronne ID
   */
  private int id;

  /**
   * Personne Name
   */
  private String nom;

  /**
   * Surname Personne
   */
  private String Prenom;

  /**
   * is it an Eleve
   * @return true if is an eleve
   */
  public abstract boolean isEleve() ;

}
