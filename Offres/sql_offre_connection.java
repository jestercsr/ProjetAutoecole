package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class sql_offre_connection {
	static String BDD = "auto_ecole";
	static String url = "jdbc:mysql://localhost:3306/" + BDD;
	static String user = "root";
	static String passwd = "root";
	
	
	
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url+"?characterEncoding=utf8", user, passwd);
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery("select * from offres");
			while (rs.next()) {
				System.out.println(""+rs.getString("id_offre")+" "+rs.getString("nom_offre"));
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
	}

}
