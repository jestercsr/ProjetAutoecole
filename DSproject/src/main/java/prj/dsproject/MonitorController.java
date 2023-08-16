package prj.dsproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static prj.dsproject.ConDB.getConnection;

public class MonitorController extends MainController implements Initializable {

//configuration tabClient from Client.fxml
    @FXML
    private TableView<Etudiant> tabClient;

    @FXML
    private TableColumn<Etudiant, Integer> id;

    @FXML
    private TableColumn<Etudiant, String> n_user;

    @FXML
    private TableColumn<Etudiant, String> p_user;

    @FXML
    private TableColumn<Etudiant, String> m_user;

    @FXML
    private TableColumn<Etudiant, String> num_user;

    @FXML
    private TableColumn<Etudiant, String> nmSt;

    @FXML
    private TableColumn<Etudiant, String> nSt;

    //configuration tab from AccueilMonitor.fxml
    @FXML
    private TableView tabEval;

    @FXML
    private TableView tabLast;

    @FXML
    private TableView tabNext;

    @FXML
    private TableColumn<Seances, Integer> n_etu;

    @FXML
    private TableColumn<Seances, String> p_etu;

    @FXML
    private TableColumn<Seances, String> n_emp;

    @FXML
    private TableColumn<Seances, String> date_ev;

    @FXML
    private TableColumn<Seances, String> h_deb;

    @FXML
    private TableColumn<Seances, String> h_fin;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //mise en place des colones dans la table (chaque col est associé à un attribut de la class Etudiant)
        id.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        p_user.setCellValueFactory(new PropertyValueFactory<>("prenom_user"));
        n_user.setCellValueFactory(new PropertyValueFactory<>("nom_user"));
        m_user.setCellValueFactory(new PropertyValueFactory<>("mail_user"));
        num_user.setCellValueFactory(new PropertyValueFactory<>("num_user"));
        nmSt.setCellValueFactory(new PropertyValueFactory<>("nom_rue"));
        nSt.setCellValueFactory(new PropertyValueFactory<>("num_rue"));

        //chargement des attributs issus de la base de donnée dans tabClient
        tabClient.setItems(getEtudiant());

    }

    public ObservableList<Etudiant> getEtudiant(){
        ObservableList<Etudiant> etu= FXCollections.observableArrayList();

        try{
            Connection con = getConnection();
            Statement st;
            ResultSet rs;

            st=con.createStatement();
            rs=st.executeQuery("select * from utilisateurs,seances");

            while(rs.next()){
                System.out.println(rs.getInt("id_user"));
                System.out.println(rs.getString("nom_user"));
                System.out.println(rs.getString("prenom_user"));
                System.out.println(rs.getString("mail_user"));
                System.out.println(rs.getString("num_user"));
                System.out.println(rs.getString("nom_user"));

                etu.add(new Etudiant(rs.getInt("id_user"), rs.getString("nom_user"),rs.getString("prenom_user"),
                        rs.getString("mail_user"),rs.getString("num_user"),rs.getString("num_rue"),rs.getString("nom_rue")));

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return etu;
    }


}


