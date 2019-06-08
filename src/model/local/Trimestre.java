package model.local;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Jerome
 */
public class Trimestre extends TableRow {

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

  public Trimestre(int id, AnneeScolaire anneeScolaire, int numero, Calendar debut, Calendar fin) {
    super(id);
    this.anneeScolaire = anneeScolaire;
    this.numero = numero;
    this.debut = debut;
    this.fin = fin;
  }

  public Trimestre(int id, AnneeScolaire anneeScolaire, int numero, Date debut, Date fin) {
    super(id);
    this.anneeScolaire = anneeScolaire;
    this.numero = numero;
    this.debut = Calendar.getInstance();
    this.debut.setTime(debut);
    this.fin = Calendar.getInstance();
    this.fin.setTime(fin);
  }

  public Trimestre(int id, AnneeScolaire anneeScolaire, int numero, String debut, String fin) throws ParseException {
    super(id);
    this.anneeScolaire = anneeScolaire;
    this.numero = numero;
    DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    date.parse(debut);
    this.debut = Calendar.getInstance();
    this.debut.setTime(date.getCalendar().getTime());
    date.parse(fin);
    this.fin = Calendar.getInstance();
    this.fin.setTime(date.getCalendar().getTime());
  }

  public AnneeScolaire getAnneeScolaire() {
    return anneeScolaire;
  }

  public int getNumero() {
    return numero;
  }

  public Calendar getDebut() {
    return debut;
  }

  public Calendar getFin() {
    return fin;
  }

  public String readId(boolean printId) {
    String tmp = "";
    for (String it : getInfo()) {
      tmp += it + " ";
    }
    return printId ? String.valueOf(id) + " : " + tmp : tmp;
  }

  Set<String> getInfo() {
    Set<String> out = new LinkedHashSet<>();
    out.add("T" + numero);
    out.addAll(anneeScolaire.getInfo());
    return out;
  }
  
  public static String simpleDate(Calendar tmp) {
    DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    return date.format(tmp.getTime());
  }

  @Override
  public String toString() {
    return "Trimestre{" + "id=" + id + ", anneeScolaire=" + anneeScolaire + ", numero=" + numero + ", debut=" + simpleDate(debut) + ", fin=" + simpleDate(fin) + '}';
  }

  @Override
  public List<String> getStringRow() {
    List<String> out = new ArrayList<>();
    out.add(String.valueOf(id));
    out.add(anneeScolaire.readId(true));
    out.add(String.valueOf(numero));
    out.add(simpleDate(debut));
    out.add(simpleDate(fin));
    return out;
  }

  @Override
  public List<String> getColumnName() {
    List<String> out = new ArrayList<>();
    out.add("ID");
    out.add("Année scolaire");
    out.add("Numero");
    out.add("Debut");
    out.add("Fin");
    return out;
  }

  @Override
  public List<String> getStringRowField() {
    List<String> out = new ArrayList<>();
    out.add(String.valueOf(id));
    out.add(String.valueOf(anneeScolaire.getId()));
    out.add(String.valueOf(numero));
    out.add(simpleDate(debut));
    out.add(simpleDate(fin));
    return out;
  }
}
