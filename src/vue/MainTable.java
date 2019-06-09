package vue;

import controleur.ManagementInterface;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

/**
 *
 * Classe : contient la fenetre principale avec le tableau courant 
 */
public class MainTable extends JPanel{

  private JTable table;
  private JScrollPane scrollPane;
  private ManagementInterface management;
  /**
   * Constructeur : initialise la table principale
   * @param model la table s'appuie sur un modele qui change en fonction des colonnes du tableau (leur nombre et leur nom) 
   * @param management les données de la tables proviennent de "management"
   */
  public MainTable(TableModel model, ManagementInterface management) {
    super(new GridLayout(1,0));
    this.management = management;
    createTable(model);
    scrollPane = new JScrollPane(table); //On creer une table, possibilité de scrollé si la table ne rentre pas dans la fenetre
    add(scrollPane);
  }
  /**
   * Methode : lorsque l'on souhaite modifier une ligne de la table (depuis les champs) 
   * @param model 
   */
  public void changeTable(TableModel model) {
    remove(scrollPane);
    createTable(model);
    scrollPane = new JScrollPane(table);
    add(scrollPane);
    validate();
 }
  /**
   * Methode : lorsque l'on souhaite creer une nouvelle ligne dans une table (depuis les champs) 
   * @param model modele contenant les informations de la table
   */
  private void createTable(TableModel model) {
    table = new JTable(model);
    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
          management.selectRow(table.getSelectedRow());
        }
      }
    });
    table.setAutoCreateRowSorter(true);
    table.setFillsViewportHeight(true);
  }
}
