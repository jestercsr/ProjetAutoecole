package prj.dsproject;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static prj.dsproject.ConDB.printSQLException;

public class LogController {

    @FXML
    private TextField tfid;

    @FXML
    private PasswordField pf;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnReg;

    public boolean checkProfile(String email, String tel, String mdp)
    {
        PreparedStatement ps;
        ResultSet rs;
        //boolean checkProfile = false;
        String query =  "SELECT * FROM utilisateurs WHERE mail_user = ? or num_user = ? and mot_passe = ?";


        try {
            ps = ConDB.getConnection().prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, tel);
            ps.setString(3, mdp);

            System.out.println(ps);

            rs = ps.executeQuery();

            if(rs.next())
            {
                return true;
            }
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return false;
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
        changePage("AccueilMoniteur", btnReg);
    }

    @FXML
    public void onClickReg() throws IOException {
        changePage("inscription", btnReg);
    }

    @FXML
    public void onClickLogin() throws IOException {
        Window owner = btnLogin.getScene().getWindow();

        System.out.println(tfid.getText());
        System.out.println(pf.getText());

        if (tfid.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Please enter your email id",
                    "Form Error!");
        }
        else if (pf.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Please enter a password",
                    "Form Error!");
        }
        String emailId = tfid.getText();
        String password = pf.getText();
        String tel = tfid.getText();


        boolean flag = checkProfile(emailId, tel, password);

        if (!flag) {
            infoBox("Please enter correct Email and Password", null, "Failed");
        } else {
            infoBox("Login Successful!", null, "Success");
            btnLogin.getScene().getWindow().hide();
            changePage("AccueilMoniteur", btnReg);
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
