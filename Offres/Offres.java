package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Clément RIOU L2INFOGR2
 * @version = 2.1
 * @
 */
public class Offres {
	static public int id_offre;
	public String nom_offre;
	public int nombre_heure_base;
	public boolean code_compris;
	public int prix_base;
	public int prix_cours;
	public int nombre_heure_cours;
	public String description;





	public Offres(String nom_offre, int nombre_heure_base, boolean code_compris, int prix_base, int prix_cours,
			int nombre_heure_cours, String description) {
		super();
		this.nom_offre = nom_offre;
		this.nombre_heure_base = nombre_heure_base;
		this.code_compris = code_compris;
		this.prix_base = prix_base;
		this.prix_cours = prix_cours;
		this.nombre_heure_cours = nombre_heure_cours;
		this.description = description;
	}



	public String getNom() {
		return nom_offre;
	}



	public int getNombre_heure_base() {
		return nombre_heure_base;
	}



	public boolean isCode_compris() {
		return code_compris;
	}



	public int getPrix_base() {
		return prix_base;
	}



	public int getPrix_cours() {
		return prix_cours;
	}



	public int getNombre_heure_cours() {
		return nombre_heure_cours;
	}
	
	
	
	public void ajouterOffreToBDD() throws SQLException {
		String query = "INSERT INTO offres VALUES("+this.id_offre+","+this.nom_offre+","+this.nombre_heure_base+","+this.prix_base+","
	+this.prix_cours+","+this.nombre_heure_cours+","+this.description+");";
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"?characterEncoding=utf8", "root", "root");
		Statement st=con.createStatement();
		ResultSet rs = st.executeQuery("query");
		
	}
	public void supprimerOffreToBDD() throws SQLException{
		String query ="DELETE from offres where id_offre="+this.id_offre+";";
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"?characterEncoding=utf8", "root", "root");
		Statement st=con.createStatement();
		ResultSet rs = st.executeQuery("query");
	}
	
	

	public float calcul_prix_total() {
//		calcul le cout total que devra d�penser le client pour ce forfait en comprenant 
//		le prix du base du forfait + le nombre d'heure que devra faire le client en plus des heures de base 
	
		return prix_base+(prix_cours*nombre_heure_cours);
	}
	public float calcul_heures_total() {
// 		calcul les heures totales de l'offre	
		return nombre_heure_base+nombre_heure_cours;
	}
	
	
	
	
	
}