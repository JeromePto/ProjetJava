package model.local;

/**
 *
 * @author Jerome
 */
public class Eleve extends Personne {

  public Eleve(int id, String nom, String Prenom) {
    super(id, nom, Prenom);
  }

  @Override
  public boolean isEleve() {
    return true;
  }

}
