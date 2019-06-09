package controleur;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.local.TableRow;

/**
 *
 * @author Jerome
 */
public class EcoleFieldModel {
  
  private List<String> fieldNames;
  private List<String> datas;
  private List<Boolean> disable;
  /**
   * 
   * @param rows 
   */
  public EcoleFieldModel(Map<Integer, TableRow> rows) {
    if (!rows.isEmpty()) {
      datas = new ArrayList<>();
      for (Map.Entry<Integer, TableRow> entry : rows.entrySet()) {
        TableRow value = entry.getValue();
        if (this.fieldNames == null) {
          fieldNames = value.getColumnName();
        }
        datas.add("");
      }
      disable = new ArrayList<>();
      for (int i = 0 ; i < fieldNames.size() ; i++) {
        
        if ((fieldNames.get(i) == "ID" || fieldNames.get(i) == "Moyenne")&&fieldNames.size()>1) { //pour desactiver la possibilité de modifier l'ID ou la moyenne d'un eleve 
          disable.add(true);
        } else {
          disable.add(false);
        }
      }
    }
  }
  
  public int getFieldCount() {
    return fieldNames.size();
  }
  
  public String getFieldName(int field) {
    return fieldNames.get(field);
  }
  
  public boolean getDisableColumn(int column) {
    return disable.get(column);
  }
}
