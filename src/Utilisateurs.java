import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Utilisateurs {
	String nom;
	String prenom;
	String mail;
	String num;
	String mdp;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	 public static void modifierInfos(String a, String b,String c,String d,String e) throws Exception {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = null;
	        try {
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/auto-ecole", "root", "");
	            PreparedStatement stmt = con.prepareStatement("INSERT INTO utilisateurs(nom_user,prenom_user,mail_user,num_user,mot_passe) VALUES (?,?,?,?,?)");
	            stmt.setString(1, a);
	            stmt.setString(2, b);
	            stmt.setString(3, c);
	            stmt.setString(4, d);
	            stmt.setString(5, e);
	            stmt.executeUpdate();
	            con.commit();
	        } catch (Exception e1) {
	            e1.printStackTrace();	        }
	    }
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//modifierInfos("Pierre","Paul","pierrepaul@gmail.com","0781175729","Azertyuiop123");
		modifierInfos("Pierre","Paul","pierrepaul@gmail.com","0781175729","Azertyuiop123");
		
		

	}

}
