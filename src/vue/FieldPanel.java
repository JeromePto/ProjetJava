/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.EcoleFieldModel;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jerome
 */
public class FieldPanel extends JPanel{
  List<JLabel> headers;
  List<JTextField> fields;
  EcoleFieldModel model;

  public FieldPanel(EcoleFieldModel model) {
    super();
    headers = new ArrayList<>();
    fields = new ArrayList<>();
    this.model = model;
    initComponents();
  }
  
  private void initComponents() {
    setLayout(new GridLayout(2, 0));    
    for(int i = 0 ; i < model.getFieldCount() ; i++) {
      headers.add(new JLabel());
      headers.get(i).setText(model.getFieldName(i));
      add(headers.get(i));
    }
    
    for(int i = 0 ; i < model.getFieldCount() ; i++) {
      fields.add(new JTextField());
      if (model.getDisableColumn(i)) {
        fields.get(i).setEditable(false);
        fields.get(i).setBackground(Color.LIGHT_GRAY);
      }
      add(fields.get(i));
    }
  }
  
  public void changeField(EcoleFieldModel model) {
    removeAll();
    headers.clear();
    fields.clear();
    this.model = model;
    for(int i = 0 ; i < model.getFieldCount() ; i++) {
      headers.add(new JLabel());
      headers.get(i).setText(model.getFieldName(i));
      add(headers.get(i));
    }
    
    for(int i = 0 ; i < model.getFieldCount() ; i++) {
      fields.add(new JTextField());
      if (model.getDisableColumn(i)) {
        fields.get(i).setEditable(false);
        fields.get(i).setBackground(Color.LIGHT_GRAY);
      }
      add(fields.get(i));
    }
    validate();
  }
  
}
