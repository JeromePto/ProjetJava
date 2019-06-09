package vue;

import controleur.ManagementInterface;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.TABLE;

/**
 * Classe qui contient tous les composants graphiques 
 * Creer une fenetre JFrame principale et lui associe des JPanels/JButtons 
 */
public class MainFrame extends JFrame implements ActionListener {

  private JPanel bottomPanel;
  private JPanel buttonPanel;
  private JButton createButton;
  private JButton deleteButton;
  private JPanel fieldPanel;
  private List<JButton> tableChange;
  private JPanel tableChoicePanel;
  private JPanel tablePanel;
  private JPanel topPanel;
  private JButton updateButton;
  private ManagementInterface management;
/**
 * Methode qui lie les données des tableaux et des champs (contenus dans la classe "management") à l'interface graphique 
 * @param management cette fonction va recuperer les données contenues dans chaque tableau 
 */
  public MainFrame(ManagementInterface management) {
    super();
    this.management = management;
    this.tablePanel = management.getTable();
    this.fieldPanel = management.getField();
    initComponents();
  }
/**
 * Jpanel contenant les boutons de creation, suppression, et modification de tableaux situé en haut de la fenetre
 * La methode va separer le JPanel du haut en deux afin d'ajouter le Jpanel dedié aux champs de saisie
 * Va creer les 3 boutons et les afficher
 */
  private void makeTopPanel() {
      /**
       * Initialisation des Jpanels pour chaque bouton  
       */
    topPanel = new JPanel();
    buttonPanel = new JPanel();
    createButton = new JButton();
    updateButton = new JButton();
    deleteButton = new JButton();

    topPanel.setLayout(new BorderLayout());
    topPanel.add(fieldPanel, BorderLayout.CENTER); //pour diviser le topPanel en 2 parties et ajouter le fieldPanel qui gere les champs de saisie

    buttonPanel.setLayout(new GridLayout());
    //ici on creer les 3 boutons d'action dans le Jpanel situé en haut du Jpanel principal
    createButton.setText("Créer");
    createButton.addActionListener(this);
    buttonPanel.add(createButton);
    
    updateButton.setText("Modifier");
    updateButton.addActionListener(this);
    buttonPanel.add(updateButton);
   
    deleteButton.setText("Supprimer");
    deleteButton.addActionListener(this);
    buttonPanel.add(deleteButton);

    topPanel.add(buttonPanel, BorderLayout.EAST);

    getContentPane().add(topPanel, BorderLayout.NORTH);
  }
/**
 * Methode d'initialisation des Jpanels/Jbuttons 
 * creer le JPanel du haut de la fenetre (contenant les boutons) à l'aide de la methode makeTopPanel 
 * Creer un Jpanel vide en bas de la fenetre dont la taille s'adaptera au JPanel principal (contenant le tableau actif)
 * Creer le JPanel de selection des tableau (à gauche) et ses boutons à l'aide d'une boucle
 */
  private void initComponents() {
    GridBagConstraints gridBagConstraints;
    tableChange = new ArrayList<>();
    makeTopPanel();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    bottomPanel = new JPanel();   //Le JPanel du bas sera vide, il s'adapte à la taille du JPanel affichant le tableau courant
    tableChoicePanel = new JPanel();
    bottomPanel.setLayout(new BorderLayout());
    bottomPanel.add(tablePanel, BorderLayout.CENTER); //Pour centrer le Jpanel qui affiche le tableau courant 
    /**
     * JPanel pour selectionner les differents tableaux
     * Boucle for qui recupere le nom de chaque tableau et creer un bouton (pour un tableau) a chaque passage de boucle
     */
    tableChoicePanel.setLayout(new GridBagLayout());
    for (int i = 0; i < 12; i++) {
      tableChange.add(new JButton());   //ajout d'un JButton a chaque passage dans la boucle 
      tableChange.get(i).setText(TABLE.name(i));    //Recupere le nom du tableau et l'affiche dans le bouton 
      tableChange.get(i).addActionListener(this);
      gridBagConstraints = new GridBagConstraints();
      gridBagConstraints.gridx = 0;
      gridBagConstraints.gridy = i;
      gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
      tableChoicePanel.add(tableChange.get(i), gridBagConstraints);
    }

    bottomPanel.add(tableChoicePanel, BorderLayout.WEST);
    getContentPane().add(bottomPanel, BorderLayout.CENTER);

    pack();
  }
/**
 * Actions des boutons de la topbar (pour creer, supprimer, modifier un tableau) et ceux de la barre de choix des tableaux
 * @param e evenement associé
 */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().getClass() == JButton.class) {
      JButton tmp = (JButton) e.getSource();
      for (int i = 0; i < 12; i++) {
        if (tmp == tableChange.get(i)) {
          management.switchTable(i);
        }
      }
      /**
       * Pour associer les JButton de la topBar à leur action respective
       */
      if (tmp == createButton) {  
        management.create();
      } else if (tmp == updateButton) {
        management.update();
      } else if (tmp == deleteButton) {
        management.delete();
      }
    }
  }

}
