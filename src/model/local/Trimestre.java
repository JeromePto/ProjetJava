package model.local;

import java.util.Calendar;
import java.util.List;

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

  public Trimestre() {
  }

  public Trimestre(int id, AnneeScolaire anneeScolaire, int numero, Calendar debut, Calendar fin, List<Bulletin> bulletins) {
    this.id = id;
    this.anneeScolaire = anneeScolaire;
    this.numero = numero;
    this.debut = debut;
    this.fin = fin;
    this.bulletins = bulletins;
  }

}
