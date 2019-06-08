/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.DAO.DAO;
import model.DAO.DAOFactory;
import model.TABLE;
import model.local.AnneeScolaire;
import model.local.Bulletin;
import model.local.Inscription;
import model.local.TableRow;
import model.local.Trimestre;
import vue.FieldPanel;
import vue.MainTable;

/**
 *
 * @author Jerome
 */
public class Management implements ManagementInterface {

  private Map<Integer, TableRow> datas;
  private final MainTable table;
  private final FieldPanel field;
  private DAO dao;
  private int type;

  public Management() {
    dao = DAOFactory.getAnneeScolaireDAO();
    type = TABLE.ANNEESCOLAIRE;
    datas = dao.findAll();
    table = new MainTable(new EcoleTableModel(datas), this);
    field = new FieldPanel(new EcoleFieldModel(datas));
  }

  @Override
  public void switchTable(int tableId) {
    dao = DAOFactory.getDAOById(tableId);
    datas = dao.findAll();
    type = tableId;
    table.changeTable(new EcoleTableModel(datas));
    field.changeField(new EcoleFieldModel(datas));
  }
  
  private void updateTable() {
    switchTable(type);
  }

  @Override
  public MainTable getTable() {
    return table;
  }

  @Override
  public FieldPanel getField() {
    return field;
  }

  @Override
  public void selectRow(int row) {
    int i = 0;
    for (Map.Entry<Integer, TableRow> entry : datas.entrySet()) {
      if (i == row) {
        fieldUpdate(entry.getValue());
      }
      i++;
    }
  }

  private void fieldUpdate(TableRow row) {
    field.fillField(row.getStringRowField());
  }

  @Override
  public void create() {
    List<String> inputs = field.getText();
    switch (type) {
      case TABLE.ANNEESCOLAIRE:
        try {
          AnneeScolaire tmp = new AnneeScolaire(Integer.parseInt(inputs.get(0)));
          dao.create(tmp);
          updateTable();
        } catch(NumberFormatException ex) {
          System.out.println(ex);
          JOptionPane.showMessageDialog(new JFrame(), "Error in fields");
        }
        break;
      case TABLE.BULLETIN:
        try {
          Bulletin tmp = new Bulletin(Integer.parseInt(inputs.get(0)), 
              inputs.get(1), 
              (Trimestre) DAOFactory.getTrimestreDAO().find(Integer.parseInt(inputs.get(2))), 
              (Inscription) DAOFactory.getInscriptionDAO().find(Integer.parseInt(inputs.get(3))));
          dao.create(tmp);
          updateTable();
        } catch(NumberFormatException ex) {
          System.out.println(ex);
          JOptionPane.showMessageDialog(new JFrame(), "Error in fields");
        }
        break;
      case TABLE.CLASSE:
        break;
      case TABLE.DETAILBULLETIN:
        break;
      case TABLE.DISCIPLINE:
        break;
      case TABLE.ELEVE:
        break;
      case TABLE.ENSEIGNEMENT:
        break;
      case TABLE.EVALUATION:
        break;
      case TABLE.INSCRIPTION:
        break;
      case TABLE.NIVEAU:
        break;
      case TABLE.PROFESSEUR:
        break;
      case TABLE.TRIMESTRE:
        break;
      default:
        throw new RuntimeException("Internal error");
    }
  }

  @Override
  public void update() {
    List<String> inputs = field.getText();
    switch (type) {
      case TABLE.ANNEESCOLAIRE:
        try {
          AnneeScolaire tmp = new AnneeScolaire(Integer.parseInt(inputs.get(0)));
          dao.update(tmp);
          updateTable();
        } catch(NumberFormatException ex) {
          System.out.println(ex);
          JOptionPane.showMessageDialog(new JFrame(), "Error in fields");
        }
        break;
      case TABLE.BULLETIN:
        try {
          Bulletin tmp = new Bulletin(Integer.parseInt(inputs.get(0)), 
              inputs.get(1), 
              (Trimestre) DAOFactory.getTrimestreDAO().find(Integer.parseInt(inputs.get(2))), 
              (Inscription) DAOFactory.getInscriptionDAO().find(Integer.parseInt(inputs.get(3))));
          dao.update(tmp);
          updateTable();
        } catch(NumberFormatException ex) {
          System.out.println(ex);
          JOptionPane.showMessageDialog(new JFrame(), "Error in fields");
        }
        break;
      case TABLE.CLASSE:
        break;
      case TABLE.DETAILBULLETIN:
        break;
      case TABLE.DISCIPLINE:
        break;
      case TABLE.ELEVE:
        break;
      case TABLE.ENSEIGNEMENT:
        break;
      case TABLE.EVALUATION:
        break;
      case TABLE.INSCRIPTION:
        break;
      case TABLE.NIVEAU:
        break;
      case TABLE.PROFESSEUR:
        break;
      case TABLE.TRIMESTRE:
        break;
      default:
        throw new RuntimeException("Internal error");
    }
  }

  @Override
  public void delete() {
    List<String> inputs = field.getText();
    switch (type) {
      case TABLE.ANNEESCOLAIRE:
        try {
          AnneeScolaire tmp = new AnneeScolaire(Integer.parseInt(inputs.get(0)));
          dao.delete(tmp);
          updateTable();
        } catch(NumberFormatException ex) {
          System.out.println(ex);
          JOptionPane.showMessageDialog(new JFrame(), "Error in fields");
        }
        break;
      case TABLE.BULLETIN:
        try {
          Bulletin tmp = new Bulletin(Integer.parseInt(inputs.get(0)), 
              inputs.get(1), 
              (Trimestre) DAOFactory.getTrimestreDAO().find(Integer.parseInt(inputs.get(2))), 
              (Inscription) DAOFactory.getInscriptionDAO().find(Integer.parseInt(inputs.get(3))));
          dao.delete(tmp);
          updateTable();
        } catch(NumberFormatException ex) {
          System.out.println(ex);
          JOptionPane.showMessageDialog(new JFrame(), "Error in fields");
        }
        break;
      case TABLE.CLASSE:
        break;
      case TABLE.DETAILBULLETIN:
        break;
      case TABLE.DISCIPLINE:
        break;
      case TABLE.ELEVE:
        break;
      case TABLE.ENSEIGNEMENT:
        break;
      case TABLE.EVALUATION:
        break;
      case TABLE.INSCRIPTION:
        break;
      case TABLE.NIVEAU:
        break;
      case TABLE.PROFESSEUR:
        break;
      case TABLE.TRIMESTRE:
        break;
      default:
        throw new RuntimeException("Internal error");
    }
  }

}
