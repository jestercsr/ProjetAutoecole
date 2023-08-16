package application;
	
public class Offres {
	public String nom;
	public int nombre_heure_base;
	public boolean code_compris;
	public int prix_base;
	public int prix_cours;
	public int nombre_heure_cours;



	public Offres(String nom, int nombre_heure_base, boolean code_compris, int prix_base, int prix_cours,
			int nombre_heure_cours) {
		super();
		this.nom = nom;
		this.nombre_heure_base = nombre_heure_base;
		this.code_compris = code_compris;
		this.prix_base = prix_base;
		this.prix_cours = prix_cours;
		this.nombre_heure_cours = nombre_heure_cours;
	}

	public String getNom() {
		return nom;
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



	public int calcul_prix_total() {
//		calcul le cout total que devra dépenser le client pour ce forfait en comprenant 
//		le prix du base du forfait + le nombre d'heure que devra faire le client en plus des heures de base 
	
		return prix_base+(prix_cours*nombre_heure_cours);
	}
	
	
	
}
