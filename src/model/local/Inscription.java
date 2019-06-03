
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

  public int getId() {
    return id;
  }

  public Classe getClasse() {
    return classe;
  }

  public Eleve getEleve() {
    return eleve;
  }
  
  public String readId(boolean printId) {
    String tmp = eleve.readId(false) + " " + classe.readId(false);
    return printId ? String.valueOf(id) + " : " + tmp : tmp;
  }

  @Override
  public String toString() {
    return "Inscription{" + "id=" + id + ", classe=" + classe + ", eleve=" + eleve + '}';
  }
}
