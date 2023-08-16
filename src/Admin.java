import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Admin {
	
	public void ajouterEvenement(String a,String b,String c,String d,Utilisateurs u) throws ClassNotFoundException {
		Evenement E = new Evenement("","","","");
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/auto-ecole", "root", "");
            PreparedStatement stmt = con.prepareStatement("INSERT INTO seances(nom_eve,date_eve,heure_deb,heure_fin,id_user) VALUES (?,?,?,?,?)");
            stmt.setString(0, a);
            stmt.setString(1, b);
            stmt.setString(2, c);
            stmt.setString(3, d);
            stmt.setString(4, u.mail);
            stmt.executeUpdate();
            con.commit();
        } catch (Exception e1) {
            e1.printStackTrace();	        }
	}
	public void modifierevenement(String a,String b,String c,String d,Utilisateurs u) throws ClassNotFoundException {
		Evenement E=new Evenement("","","","");
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/auto-ecole", "root", "");
            PreparedStatement stmt = con.prepareStatement("UPDATE seances SET nom_eve='a',date_eve='b',heure_deb='c',heure_fin='d'");
        } catch (Exception e1) {
            e1.printStackTrace();	        }
	}
	
	public void supprimerevenement(String a) throws ClassNotFoundException {
		Evenement E=new Evenement("","","","");
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/auto-ecole", "root", "");
            PreparedStatement stmt = con.prepareStatement("DELETE FROM seances WHERE nom_eve='a'");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
	}

}
