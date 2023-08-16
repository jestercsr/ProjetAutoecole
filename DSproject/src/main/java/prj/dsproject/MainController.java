package prj.dsproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import static prj.dsproject.ConDB.getConnection;

//Page dédiée à l'implementation des methodes utilisiable sur les pages AccueilMoniteur/User/Admin

public class MainController implements Initializable {

    @FXML
    private Button btnUsers;

    @FXML
    private Button btnMain;

    @FXML
    private Button btnPlan;

    @FXML
    private Button btnOffre;

    @FXML
    private Button btnAsk;

    @FXML
    private Button btnEval;

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

    @FXML
    private TableColumn<Seances, Integer> n_etu1;

    @FXML
    private TableColumn<Seances, String> p_etu1;

    @FXML
    private TableColumn<Seances, String> n_emp1;

    @FXML
    private TableColumn<Seances, String> date_ev1;

    @FXML
    private TableColumn<Seances, String> h_deb1;

    @FXML
    private TableColumn<Seances, String> h_fin1;

    @FXML
    private TableColumn<Seances, Integer> n_etu2;

    @FXML
    private TableColumn<Seances, String> p_etu2;

    @FXML
    private TableColumn<Seances, String> n_emp2;

    @FXML
    private TableColumn<Seances, String> date_ev2;

    @FXML
    private TableColumn<Seances, String> h_deb2;

    @FXML
    private TableColumn<Seances, String> h_fin2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //mise en place des colones dans la table (chaque col est associé à un attribut de la class Seance)
        n_etu.setCellValueFactory(new PropertyValueFactory<>("nom_user"));
        p_etu.setCellValueFactory(new PropertyValueFactory<>("prenom_user"));
        n_emp.setCellValueFactory(new PropertyValueFactory<>("nom_emp"));
        date_ev.setCellValueFactory(new PropertyValueFactory<>("date_eve"));
        h_deb.setCellValueFactory(new PropertyValueFactory<>("heure_debut"));
        h_fin.setCellValueFactory(new PropertyValueFactory<>("heure_fin"));

        n_etu1.setCellValueFactory(new PropertyValueFactory<>("nom_user"));
        p_etu1.setCellValueFactory(new PropertyValueFactory<>("prenom_user"));
        n_emp1.setCellValueFactory(new PropertyValueFactory<>("nom_emp"));
        date_ev1.setCellValueFactory(new PropertyValueFactory<>("date_eve"));
        h_deb1.setCellValueFactory(new PropertyValueFactory<>("heure_debut"));
        h_fin1.setCellValueFactory(new PropertyValueFactory<>("heure_fin"));

        n_etu2.setCellValueFactory(new PropertyValueFactory<>("nom_user"));
        p_etu2.setCellValueFactory(new PropertyValueFactory<>("prenom_user"));
        n_emp2.setCellValueFactory(new PropertyValueFactory<>("nom_emp"));
        date_ev2.setCellValueFactory(new PropertyValueFactory<>("date_eve"));
        h_deb2.setCellValueFactory(new PropertyValueFactory<>("heure_debut"));
        h_fin2.setCellValueFactory(new PropertyValueFactory<>("heure_fin"));

        //chargement des attributs issus de la base de donnée dans tabEval
        tabEval.setItems(getEval());//table evaluation à venir
        tabLast.setItems(getLastSeance());//table dernières seances effectué
        tabNext.setItems(getNextSeance());//table prochaines seances à effectuer


    }

    public ObservableList<Seances> getEval(){
        ObservableList<Seances> eval= FXCollections.observableArrayList();

        try{
            Connection con = getConnection();
            Statement st;
            ResultSet rs;

            st=con.createStatement();
            rs=st.executeQuery("select distinct * from utilisateurs,seances,moniteurs where seances.id_user=utilisateurs.id_user and seances.id_emp=moniteurs.id_emp and nom_eve = 'Evaluation' and date_eve > DATE(NOW())");

            while(rs.next()){
                System.out.println(rs.getString("nom_user"));
                System.out.println(rs.getString("prenom_user"));
                System.out.println(rs.getString("nom_emp"));
                System.out.println(rs.getString("date_eve"));
                System.out.println(rs.getString("heure_debut"));
                System.out.println(rs.getString("heure_fin"));

                eval.add(new Seances(rs.getString("nom_user"), rs.getString("prenom_user"),rs.getString("nom_emp"),
                        rs.getString("date_eve"),rs.getString("heure_debut"),rs.getString("heure_fin")));

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return eval;
    }

    public ObservableList<Seances> getLastSeance(){
        ObservableList<Seances> seancesLast= FXCollections.observableArrayList();

        try{
            Connection con = getConnection();
            Statement st;
            ResultSet rs;

            st=con.createStatement();
            rs=st.executeQuery("select distinct * from utilisateurs,seances,moniteurs where seances.id_user=utilisateurs.id_user and seances.id_emp=moniteurs.id_emp and nom_eve = 'Seance' and date_eve < DATE(NOW())");

            while(rs.next()){
                System.out.println(rs.getString("nom_user"));
                System.out.println(rs.getString("prenom_user"));
                System.out.println(rs.getString("nom_emp"));
                System.out.println(rs.getString("date_eve"));
                System.out.println(rs.getString("heure_debut"));
                System.out.println(rs.getString("heure_fin"));

                seancesLast.add(new Seances(rs.getString("nom_user"), rs.getString("prenom_user"),rs.getString("nom_emp"),
                        rs.getString("date_eve"),rs.getString("heure_debut"),rs.getString("heure_fin")));

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return seancesLast;
    }

    public ObservableList<Seances> getNextSeance(){
        ObservableList<Seances> seancesNext= FXCollections.observableArrayList();

        try{
            Connection con = getConnection();
            Statement st;
            ResultSet rs;

            st=con.createStatement();
            rs=st.executeQuery("select distinct * from utilisateurs,seances,moniteurs where seances.id_user=utilisateurs.id_user and seances.id_emp=moniteurs.id_emp and nom_eve = 'Seance' and date_eve > DATE(NOW())");

            while(rs.next()){
                System.out.println(rs.getString("nom_user"));
                System.out.println(rs.getString("prenom_user"));
                System.out.println(rs.getString("nom_emp"));
                System.out.println(rs.getString("date_eve"));
                System.out.println(rs.getString("heure_debut"));
                System.out.println(rs.getString("heure_fin"));

                seancesNext.add(new Seances(rs.getString("nom_user"), rs.getString("prenom_user"),rs.getString("nom_emp"),
                        rs.getString("date_eve"),rs.getString("heure_debut"),rs.getString("heure_fin")));

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return seancesNext;
    }



    @FXML
    public void changePage(String fileName, Button event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fileName + ".fxml"));
        Scene scene = new Scene(root);
        Stage appStage = (Stage) event.getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    public void onClickMain() throws IOException {
        changePage("AccueilMoniteur", btnMain);
    }
    @FXML
    public void onClickUsers() throws IOException {
        changePage("Client", btnUsers);
    }

    @FXML
    public void onClickOffre() throws IOException {
        changePage("Offre", btnOffre);
    }

    @FXML
    public void onClickPlan() throws IOException {
        changePage("Offre", btnPlan);
    }
    @FXML
    public void onClickAsk() throws IOException {
        changePage("RequestRegister", btnAsk);
    }

    @FXML
    public void viewReg() throws IOException {
        changePage("RegisteredUsers", btnAsk);
    }

    @FXML
    public void viewCurrentAsk() throws IOException {
        changePage("CurrentAsks", btnAsk);
    }

    //main menu for monitor
    public void onClickEval() throws IOException {
        changePage("Evaluation", btnEval);
    }

}
