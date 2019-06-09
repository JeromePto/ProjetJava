/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.local;

import java.util.List;

/**
 *
 * 
 */
public abstract class TableRow {
  
  protected int id;

  public TableRow(int id) {
    this.id = id;
  }
  
  public abstract List<String> getStringRow();
  public abstract List<String> getColumnName();
  public abstract List<String> getStringRowField();
  
  public int getId() {
    return id;
  }
}
