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

  public Personne(int id, String nom, String Prenom) {
    this.id = id;
    this.nom = nom;
    this.Prenom = Prenom;
  }

  /**
   * is it an Eleve ?
   *
   * @return true if is an eleve
   */
  public abstract boolean isEleve();

  @Override
  public String toString() {
    return "Personne{" + "id=" + id + ", nom=" + nom + ", Prenom=" + Prenom + '}';
  }

  public int getId() {
    return id;
  }

  public String getNom() {
    return nom;
  }

  public String getPrenom() {
    return Prenom;
  }
    
}
