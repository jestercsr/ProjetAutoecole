import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {

	public static void main(String[] args) {
		// Connection à la base de données/
		String BDD = "auto-ecole";
		String url = "jdbc:mysql://localhost:3306/" + BDD;
		String user = "root";
		String passwd = "";

		// Essai de connexion à la base de données
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connecté");
		} catch (Exception e){
		     e.printStackTrace();
			 System.out.println("Erreur");
			 System.exit(0);
		}
	}

}
