
package model.local;

/**
 * 
 * @author Jerome
 */
public class AnneeScolaire {
  /**
   * AnneeScolaire ID
   */
  private int id;

  public AnneeScolaire(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "AnneeScolaire{" + "id=" + id + '}';
  }

  public int getId() {
    return id;
  }
  
  public String readId(boolean printId) {
    String tmp = String.valueOf(id) + "-" + String.valueOf(id+1);
    return printId ? String.valueOf(id) + " : " + tmp : tmp;
  }

}
