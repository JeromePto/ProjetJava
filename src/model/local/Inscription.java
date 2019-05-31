
package model.local;

import java.util.List;

/**
 * 
 * @author Jerome
 */
public class Inscription {
  /**
   * Inscription ID
   */
  private int id;

  private Classe classe;

  private Eleve eleve;

  private List<Bulletin> bulletins;

  public Inscription() {
  }

  public Inscription(int id, Classe classe, Eleve eleve, List<Bulletin> bulletins) {
    this.id = id;
    this.classe = classe;
    this.eleve = eleve;
    this.bulletins = bulletins;
  }

  
}
