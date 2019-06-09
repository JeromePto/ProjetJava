package model.local;

/**
 *
 * 
 */
public class Eleve extends Personne {

  public Eleve(int id, String nom, String prenom) {
    super(id, nom, prenom);
  }

  @Override
  public boolean isEleve() {
    return true;
  }

}
