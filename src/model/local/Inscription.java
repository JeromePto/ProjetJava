
package model.local;

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

  public Inscription() {
  }

  public Inscription(int id, Classe classe, Eleve eleve) {
    this.id = id;
    this.classe = classe;
    this.eleve = eleve;
  }

  @Override
  public String toString() {
    return "Inscription{" + "id=" + id + ", classe=" + classe + ", eleve=" + eleve + '}';
  }
}
