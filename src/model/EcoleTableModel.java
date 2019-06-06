/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;
import model.local.TableRow;

/**
 *
 * @author Jerome
 */
public class EcoleTableModel extends AbstractTableModel{
  
  private List<String> columnNames;
  private List<List<String>> datas;

  public EcoleTableModel(Map<Integer, TableRow> rows) {
    if (!rows.isEmpty()) {
      datas = new ArrayList<>();
      for (Map.Entry<Integer, TableRow> entry : rows.entrySet()) {
        TableRow value = entry.getValue();
        if (this.columnNames == null) {
          columnNames = value.getColumnName();
        }
        datas.add(value.getStringRow());
      }
    }
  }
  
  @Override
  public int getRowCount() {
    return datas.size();
  }

  @Override
  public int getColumnCount() {
    return columnNames.size();
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    return datas.get(rowIndex).get(columnIndex);
  }

  @Override
  public String getColumnName(int column) {
    return columnNames.get(column);
  }
  
  
}
