package prj.dsproject;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegController{

    @FXML
    private TextField email;

   // @FXML private CheckBox chkbx;

    @FXML
    private TextField num;

    @FXML
    private DatePicker date;

    @FXML
    private TextField cpost;

    @FXML
    private TextField city;

    @FXML
    private TextField numRue;

    @FXML
    private TextField nmRue;

    @FXML
    private TextField cads;

    @FXML
    private TextField nm;

    @FXML
    private TextField pnm;

    @FXML
    private PasswordField mdp;

    @FXML
    private PasswordField cmdp;

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnReturn;

    public static final Pattern valid_email =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static final Pattern valid_passwd =
            Pattern.compile("^[A-Z0-9_]{12,25}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = valid_email.matcher(emailStr);
        return matcher.find();
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
    public void OnClickReturn() throws IOException {
        changePage("connexion", btnReturn);
    }

   /*checkbox afficher passwordfield
    @FXML
    void onClickUnmask() {
        if (chkbx.isSelected()){
            mdp.setPromptText(mdp.getText());
            mdp.setText("");
            mdp.setVisible(true);
        }else {
            mdp.setText(mdp.getPromptText());
            mdp.setPromptText("");
            mdp.setVisible(false);
        }
    }*/

    public static boolean validatePsw(String passwdStr) {
        Matcher matcher = valid_passwd.matcher(passwdStr);
        return matcher.find();
    }

    public boolean checkProfile(String profile)
    {
        PreparedStatement ps;
        ResultSet rs;
        boolean checkProfile = false;
        String query =  "SELECT * FROM utilisateurs WHERE mail_user = ?";


        try {
            ps = ConDB.getConnection().prepareStatement(query);
            ps.setString(1, profile);
            rs = ps.executeQuery();

            if(rs.next())
            {
                checkProfile = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return checkProfile;
    }

    @FXML
    public void OnClickRegister() {
        Window owner = btnRegister.getScene().getWindow();

        System.out.println(email.getText());
        System.out.println(mdp.getText());
        System.out.println(cmdp.getText());
        System.out.println(pnm.getText());
        System.out.println(nm.getText());
        System.out.println(city.getText());
        System.out.println(cpost.getText());
        System.out.println(nmRue.getText());
        System.out.println(numRue.getText());

        String birthdate = date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String fstName = pnm.getText();
        String lstName = nm.getText();
        String emailId = email.getText();
        String phoneNum = num.getText();
        String password = mdp.getText();
        String numSt = numRue.getText();
        String nameSt = nmRue.getText();
        String town = city.getText();
        String postCod = cpost.getText();
        String complementAds = cads.getText();


            if(email.getText().isEmpty()){
            showAlert(Alert.AlertType.CONFIRMATION, owner, "Please enter an email address", "Error");
        }

        else if(!validate(email.getText())){
            showAlert(Alert.AlertType.CONFIRMATION, owner, "Please enter a valid email address", "Error");
        }

        else if(numRue.getText().isEmpty()|| nmRue.getText().isEmpty() ||city.getText().isEmpty()||
                    cpost.getText().isEmpty() || email.getText().isEmpty() || num.getText().isEmpty())
        {
            showAlert(Alert.AlertType.CONFIRMATION, owner, "Please enter your coordinates", "Error");
        }

        else if(nm.getText().isEmpty())
        {
            showAlert(Alert.AlertType.CONFIRMATION, owner, "Add a firstname", "Error");
        }

        else if(mdp.getText().isEmpty())
        {
            showAlert(Alert.AlertType.CONFIRMATION, owner, "Add A Password", "Error");
        }
        else if(!validatePsw(mdp.getText()))
        {
            showAlert(Alert.AlertType.CONFIRMATION, owner, "Please enter a correct password", "Error");
        }
        else if(!(mdp.getText().equals(cmdp.getText())))
        {
            showAlert(Alert.AlertType.CONFIRMATION, owner, "Retype The Password Again", "Error");
        }

        else if(checkProfile(String.valueOf(email)))
        {
            showAlert(Alert.AlertType.CONFIRMATION, owner,"This User Already Exist", "Error");
        }

        /*else if(birthdate<){
            showAlert(Alert.AlertType.CONFIRMATION, owner,"Age error", "Error");
            }*/

        else{

            PreparedStatement ps;
            String sql_register = "INSERT INTO utilisateurs (nom_user, prenom_user, date_nais, mail_user, num_user, num_rue, nom_rue, code_postal, nom_ville, complément_adress, mot_passe, etat_compte) VALUES (?,?,?,?,?,?,?,?,?,?,?,'En cours')";

            try {
                ps = ConDB.getConnection().prepareStatement(sql_register);

                ps.setString(1, lstName);
                ps.setString(2, fstName);
                ps.setString(3, birthdate);
                ps.setString(4, emailId);
                ps.setString(5, phoneNum);
                ps.setString(6, numSt);
                ps.setString(7, nameSt);
                ps.setString(8, postCod);
                ps.setString(9, town);
                ps.setString(10, complementAds);
                ps.setString(11, password);

                if(ps.executeUpdate() > 0)
                {
                    //showAlert(Alert.AlertType.CONFIRMATION, owner, "New User Add",  "Welcome " + email.getText());
                    infoBox("New User Add", null, "Welcome " + email.getText());
                }

            } catch (SQLException ex) {
                Logger.getLogger(RegController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }


    private static void showAlert(Alert.AlertType alertType, Window owner, String message, String title) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
