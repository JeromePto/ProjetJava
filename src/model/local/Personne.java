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
  protected String prenom;

  public Personne(int id, String nom, String prenom) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
  }

  /**
   * is it an Eleve ?
   *
   * @return true if is an eleve
   */
  public abstract boolean isEleve();

  @Override
  public String toString() {
    return "Personne{" + "id=" + id + ", nom=" + nom + ", Prenom=" + prenom + '}';
  }

  public int getId() {
    return id;
  }

  public String getNom() {
    return nom;
  }

  public String getPrenom() {
    return prenom;
  }
  
  public String readId(boolean printId) {
    String tmp = (isEleve() ? "Eleve" : "Prof") + " " + prenom + " " + nom;
    return printId ? String.valueOf(id) + " : " + tmp : tmp;
  }
  
    
}
