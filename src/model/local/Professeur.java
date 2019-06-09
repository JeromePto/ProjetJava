
package model.local;

/**
 * 
 * 
 */
public class Professeur extends Personne {

  @Override
  public boolean isEleve() {
    return false;
  }

  public Professeur(int id, String nom, String prenom) {
    super(id, nom, prenom);
  }

  
}
