/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author Jerome
 */
public class MainTable extends JPanel{

  private JTable table;
  JScrollPane scrollPane;
  
  public MainTable(TableModel model) {
    super(new GridLayout(1,0));
    table = new JTable(model);
    //table.setPreferredScrollableViewportSize(new Dimension(500, 70));
    table.setFillsViewportHeight(true);
    scrollPane = new JScrollPane(table);
    add(scrollPane);
  }
  
  public void changeTable(TableModel model) {
    remove(scrollPane);
    table = new JTable(model);
    //table.setPreferredScrollableViewportSize(new Dimension(500, 70));
    table.setFillsViewportHeight(true);
    scrollPane = new JScrollPane(table);
    add(scrollPane);
    validate();
 }
}
