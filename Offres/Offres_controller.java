package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Offres_controller {
	
	/**
	 * @author Clément RIOU L2INFOGR2
	 * @version = 1.6
	 * @
	 */
	Candidat candidat_actif = new Candidat(null,null,25,40,-1);
	/// Différentes Offres dispo :
	/// pas de description encore
	
	
	Offres offre1=new Offres("Permis B", 20, false, 1000, 50, candidat_actif.getNbHeures(), null) ;	
	Offres offre2=new Offres("Permis auto", 20, true, 900, 45, candidat_actif.getNbHeures(), null) ;	

    @FXML
    private Label label_etat;
	
    @FXML
    private Button offres_1;

    @FXML
    private Button offres_2;

    @FXML
    private Button offres_3;
    
    
    @FXML
    void ajouter(ActionEvent event) {
    	if (((Node) event.getSource()).getId().equals("offres_1")) {
    		candidat_actif.setOffre(offre1);
    		System.out.println("Le button offre_1 est appuyé");
    		offres_1.setText("Offre choisie !");
    		label_etat.setText("Le button offre_1 est appuyé");
    	}
    	else if (offres_2.getId().equals("offres_2")) {
    		candidat_actif.setOffre(offre2);
    		System.out.println("Le button offre_2 est appuyé");
    		offres_1.setText("Offre choisie !");
    		label_etat.setText("Le button offre_2 est appuyé");
    	}
    	else if (offres_3.getId().equals("offres_3")) {
    		
    	}
    }

}
