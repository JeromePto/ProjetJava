/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.Management;
import controleur.ManagementInterface;
import java.awt.GridLayout;
import java.util.EventListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Jerome
 */
//Tableau principal en JPanel
public class MainTable extends JPanel{

  private JTable table;
  private JScrollPane scrollPane;
  private ManagementInterface management;
  
  public MainTable(TableModel model, ManagementInterface management) {
    super(new GridLayout(1,0));
    this.management = management;
    createTable(model);
    scrollPane = new JScrollPane(table);
    add(scrollPane);
  }
  
  public void changeTable(TableModel model) {
    remove(scrollPane);
    createTable(model);
    scrollPane = new JScrollPane(table);
    add(scrollPane);
    validate();
 }
  
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
