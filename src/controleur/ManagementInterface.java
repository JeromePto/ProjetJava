/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.util.Map;
import vue.FieldPanel;
import vue.MainTable;

/**
 *
 * @author Jerome
 */
public interface ManagementInterface {
  public MainTable getTable();
  public FieldPanel getField();
  public void switchTable(int tableId);
  public void selectRow(int row);
  public void create();
  public void update();
  public void delete();
  public Map<String, Integer> getReporting();
}
