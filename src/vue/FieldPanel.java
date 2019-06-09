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
 * Classe qui gere les champs de saisie permettant de modifier ou ajouter une ligne à un tableau de données
 */
public class FieldPanel extends JPanel{
  List<JLabel> headers;
  List<JTextField> fields;
  EcoleFieldModel model;
/**
 * Methode : le JPanel de champs est associé à un modele qui depend du tableau courant affiché (les champs comme la moyenne ou le niveau sont associé aux eleves, les champs seront differents pour un autre tableau) 
 * @param model modele associé au tableau courant
 */
  public FieldPanel(EcoleFieldModel model) {
    super();
    headers = new ArrayList<>();
    fields = new ArrayList<>();
    this.model = model;
    initComponents();
  }
  /**
   * Methode : initialisation des champs
   * Le nombre de ces champs peut varier selon le tableau courant, on utilise donc une boucle for qui recupere les noms des colonnes du tableau courant pour les ajouter dans la plage de champs
   */
  private void initComponents() {
    setLayout(new GridLayout(2, 0));    
    for(int i = 0 ; i < model.getFieldCount() ; i++) { 
      headers.add(new JLabel());
      headers.get(i).setText(model.getFieldName(i));
      add(headers.get(i));
    }
    /**
     * Pour eviter de pouvoir modifier l'ID, la moyenne d'un eleve... on supprime le champ et on grise la case
     */
    for(int i = 0 ; i < model.getFieldCount() ; i++) {
      fields.add(new JTextField());
      if (model.getDisableColumn(i)) {
        fields.get(i).setEditable(false); //dans ecoleFieldModel on applique un booleen 'false' sur l'ID et la moyenne d'un eleve, c'est ici qu'on le recupere
        fields.get(i).setBackground(Color.LIGHT_GRAY);
      }
      add(fields.get(i));
    }
  }
  /**
   * Methode : mise a jour des champs et de leur nom 
   * On supprime tous les champs actuel, on applique le modele associé au tableau courant, on copie les noms de colonne (correspondant aux champs) dans le JPanel de champs et on ajoute des champs de saisie
   * On rend l'ID non modifiable
   * @param model pour mettre à jour ces champs, on fait appel a un modele qui correspond aux nom des colonnes du tableau courant
   */
  public void changeField(EcoleFieldModel model) {
    removeAll();
    headers.clear();
    fields.clear(); //On clear les champs
    this.model = model; //On applique le modele 
    for(int i = 0 ; i < model.getFieldCount() ; i++) { //selon le nombre de champs (colonne) dans le tableau courant...
      headers.add(new JLabel());
      headers.get(i).setText(model.getFieldName(i));  //...on ajoute un JLabel devant chaque champ et on recupere et affiche le nom de la colonne à cet endroit   
      add(headers.get(i));
    }
    
    for(int i = 0 ; i < model.getFieldCount() ; i++) {  //Meme chose pour les champs de saisie, selon le nombre de colonne du tableau, on creer les champs de saisies à l'aide d'une boucle
      fields.add(new JTextField());
      if (model.getDisableColumn(i)) { //si 
        fields.get(i).setEditable(false);
        fields.get(i).setBackground(Color.LIGHT_GRAY); //On rend certains champs non modifiabl (ID, moyenne...)
      }
      add(fields.get(i));
    }
    validate();
  }
  /**
   * Methode de remplissage automatique des champs lorsque l'on selectionne une ligne du tableau courant
   * @param values recupere la ligne selectionnée
   */
  public void fillField(List<String> values) {
    if (values.size() != fields.size()) {
      throw new RuntimeException("Internal error 3");
    }
    for(int i = 0 ; i < values.size() ; i++) {
      fields.get(i).setText(values.get(i));
    }    
  }
  
  public List<String> getText() {
    List<String> out = new ArrayList<>();
    for(JTextField it : fields) {
      out.add(it.getText());
    }
    return out;
  }
}
