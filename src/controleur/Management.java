/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.DAO.DAO;
import model.DAO.DAOFactory;
import model.TABLE;
import model.local.AnneeScolaire;
import model.local.Bulletin;
import model.local.Classe;
import model.local.DetailBulletin;
import model.local.Discipline;
import model.local.Eleve;
import model.local.Enseignement;
import model.local.Evaluation;
import model.local.Inscription;
import model.local.Niveau;
import model.local.Professeur;
import model.local.TableRow;
import model.local.Trimestre;
import vue.FieldPanel;
import vue.MainTable;
import vue.ReportingFrame;

/**
 *
 * 
 */
public class Management implements ManagementInterface {

  private Map<Integer, TableRow> datas;
  private final MainTable table;
  private final FieldPanel field;
  private final ReportingFrame report;
  private DAO dao;
  private int type;

  public Management() {
    dao = DAOFactory.getAnneeScolaireDAO();
    type = TABLE.ANNEESCOLAIRE;
    datas = dao.findAll();
    table = new MainTable(new EcoleTableModel(datas), this);
    field = new FieldPanel(new EcoleFieldModel(datas));
    report = new ReportingFrame(this);
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
        field.fillField(entry.getValue().getStringRowField());
      }
      i++;
    }
  }

  private TableRow rowFromField() throws NumberFormatException, SQLException, IllegalArgumentException {
    List<String> inputs = field.getText();
    if (inputs.get(0).equals("") && type != TABLE.ANNEESCOLAIRE) {
      inputs.set(0, "-1");
    }
    TableRow out = null;
    switch (type) {
      case TABLE.ANNEESCOLAIRE:
        out = new AnneeScolaire(Integer.parseInt(inputs.get(0)));
        break;
      case TABLE.BULLETIN:
        out = new Bulletin(Integer.parseInt(inputs.get(0)),
            inputs.get(1),
            (Trimestre) DAOFactory.getTrimestreDAO().find(Integer.parseInt(inputs.get(2))),
            (Inscription) DAOFactory.getInscriptionDAO().find(Integer.parseInt(inputs.get(3)))
        );
        break;
      case TABLE.CLASSE:
        out = new Classe(Integer.parseInt(inputs.get(0)),
            inputs.get(1),
            (AnneeScolaire) DAOFactory.getAnneeScolaireDAO().find(Integer.parseInt(inputs.get(2))),
            (Niveau) DAOFactory.getNiveauDAO().find(Integer.parseInt(inputs.get(3)))
        );
        break;
      case TABLE.DETAILBULLETIN:
        out = new DetailBulletin(Integer.parseInt(inputs.get(0)),
            inputs.get(1),
            (Enseignement) DAOFactory.getEnseignementDAO().find(Integer.parseInt(inputs.get(2))),
            (Bulletin) DAOFactory.getBulletinDAO().find(Integer.parseInt(inputs.get(3)))
        );
        break;
      case TABLE.DISCIPLINE:
        out = new Discipline(Integer.parseInt(inputs.get(0)),
            inputs.get(1)
        );
        break;
      case TABLE.ELEVE:
        out = new Eleve(Integer.parseInt(inputs.get(0)),
            inputs.get(1),
            inputs.get(2)
        );
        break;
      case TABLE.ENSEIGNEMENT:
        out = new Enseignement(Integer.parseInt(inputs.get(0)),
            (Classe) DAOFactory.getClasseDAO().find(Integer.parseInt(inputs.get(1))),
            (Discipline) DAOFactory.getDisciplineDAO().find(Integer.parseInt(inputs.get(2))),
            (Professeur) DAOFactory.getProfesseurDAO().find(Integer.parseInt(inputs.get(3)))
        );
        break;
      case TABLE.EVALUATION:
        out = new Evaluation(Integer.parseInt(inputs.get(0)),
            Float.parseFloat(inputs.get(1)),
            inputs.get(2),
            (DetailBulletin) DAOFactory.getDetailBulletinDAO().find(Integer.parseInt(inputs.get(3)))
        );
        break;
      case TABLE.INSCRIPTION:
        out = new Inscription(Integer.parseInt(inputs.get(0)),
            (Classe) DAOFactory.getClasseDAO().find(Integer.parseInt(inputs.get(1))),
            (Eleve) DAOFactory.getEleveDAO().find(Integer.parseInt(inputs.get(2)))
        );
        break;
      case TABLE.NIVEAU:
        out = new Niveau(Integer.parseInt(inputs.get(0)),
            inputs.get(2)
        );
        break;
      case TABLE.PROFESSEUR:
        out = new Professeur(Integer.parseInt(inputs.get(0)),
            inputs.get(1),
            inputs.get(2)
        );
        break;
      case TABLE.TRIMESTRE: {
        try {
          out = new Trimestre(Integer.parseInt(inputs.get(0)),
              (AnneeScolaire) DAOFactory.getAnneeScolaireDAO().find(Integer.parseInt(inputs.get(1))),
              Integer.parseInt(inputs.get(2)),
              inputs.get(3),
              inputs.get(4)
          );
        } catch (ParseException ex) {
          throw new NumberFormatException(ex.toString());
        }
      }
      break;
      default:
        throw new RuntimeException("Internal error");
    }
    return out;
  }

  @Override
  public void create() {
    TableRow tmp;
    try {
      tmp = rowFromField();
      dao.create(tmp);
      updateTable();
    } catch (NumberFormatException ex) {
      System.out.println(ex);
      JOptionPane.showMessageDialog(new JFrame(), "Error in fields", "Format error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(new JFrame(), "Error in fields", "SQL error", JOptionPane.ERROR_MESSAGE);
      System.out.println(ex);
    } catch (IllegalArgumentException ex) {
      JOptionPane.showMessageDialog(new JFrame(), "Error in fields : An ID doesn't exist", "SQL error", JOptionPane.ERROR_MESSAGE);
      System.out.println(ex);
    }
  }

  @Override
  public void update() {
    TableRow tmp;
    try {
      tmp = rowFromField();
      dao.update(tmp);
      updateTable();
    } catch (NumberFormatException ex) {
      System.out.println(ex);
      JOptionPane.showMessageDialog(new JFrame(), "Error in fields", "Format error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(new JFrame(), "Error in fields", "SQL error", JOptionPane.ERROR_MESSAGE);
      System.out.println(ex);
    } catch (IllegalArgumentException ex) {
      JOptionPane.showMessageDialog(new JFrame(), "Error in fields : An ID doesn't exist", "SQL error", JOptionPane.ERROR_MESSAGE);
      System.out.println(ex);
    }
  }

  @Override
  public void delete() {
    TableRow tmp;
    try {
      tmp = rowFromField();
      dao.delete(tmp);
      updateTable();
    } catch (NumberFormatException ex) {
      System.out.println(ex);
      JOptionPane.showMessageDialog(new JFrame(), "Error in fields", "Format error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(new JFrame(), "Error in fields", "SQL error", JOptionPane.ERROR_MESSAGE);
      System.out.println(ex);
    } catch (IllegalArgumentException ex) {
      JOptionPane.showMessageDialog(new JFrame(), "Error in fields : An ID doesn't exist", "SQL error", JOptionPane.ERROR_MESSAGE);
      System.out.println(ex);
    }
  }

  @Override
  public Map<String, Integer> getReporting() {
    Map<String, Integer> out = new HashMap<>();
    DAO<Classe> dao = DAOFactory.getClasseDAO();
    DAO<Inscription> dao2 = DAOFactory.getInscriptionDAO();
    for (Map.Entry<Integer, TableRow> it : dao.findAll().entrySet()) {
      out.put(((Classe) it.getValue()).getNom(), 0);
      for (Map.Entry<Integer, TableRow> it2 : dao2.findAll().entrySet()) {
        if (((Inscription) it2.getValue()).getClasse().getNom().equals(((Classe) it.getValue()).getNom())) {
          out.replace(((Classe) it.getValue()).getNom(), out.get(((Classe) it.getValue()).getNom())+1);
        }
      }
    }
    return out;
  }
  
}
