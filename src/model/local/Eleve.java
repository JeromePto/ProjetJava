package model.local;

import java.util.List;

/**
 *
 * @author Jerome
 */
public class Eleve extends Personne {

  private List<Inscription> inscriptions;

  public Eleve() {
  }

  public Eleve(List<Inscription> inscriptions) {
    this.inscriptions = inscriptions;
  }

  @Override
  public boolean isEleve() {
    return true;
  }

}
