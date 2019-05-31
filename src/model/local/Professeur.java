
package model.local;

import java.util.List;

/**
 * 
 * @author Jerome
 */
public class Professeur extends Personne {
  private List<Enseignement> enseignements;

  @Override
  public boolean isEleve() {
    return false;
  }

  public Professeur() {
    super();
  }

  public Professeur(int id, String nom, String Prenom, List<Enseignement> enseignements) {
    super(id, nom, Prenom);
    this.enseignements = enseignements;
  }

  
}
