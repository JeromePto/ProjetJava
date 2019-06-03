
package model.local;

/**
 * 
 * @author Jerome
 */
public class Trimestre {
  /**
   * Trimestre ID
   */
  private int id;

  private AnneeScolaire anneeScolaire;

  /**
   * Trimestre number (1-3)
   */
  private int numero;

  /**
   * Starting trimestre date
   */
  private Calendar debut;

  /**
   * Ending trimestre date
   */
  private Calendar fin;

  private List<Bulletin> bulletins;

}
