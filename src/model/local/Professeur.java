
package model.local;

/**
 * 
 * @author Jerome
 */
public class Professeur extends Personne {

  @Override
  public boolean isEleve() {
    return false;
  }

  public Professeur(int id, String nom, String Prenom) {
    super(id, nom, Prenom);
  }

  
}
