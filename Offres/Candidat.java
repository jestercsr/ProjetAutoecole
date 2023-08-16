package application;

public class Candidat {
	/**
	 * @author Clément RIOU L2INFOGR2
	 * @version = 1.3
	 * @
	 */

	private Offres offre ;
	private String permis;
	private int nbHeures;
	private int resultatCode;
	private float resultatPermis;
	

	
	public Candidat(Offres offre, String permis, int nbHeures, int resultatCode, float resultatPermis) {
		super();
		this.offre = offre;
		this.permis = permis;
		this.nbHeures = nbHeures;
		this.resultatCode = resultatCode;
		this.resultatPermis = resultatPermis;
	}
	
	public void Offre_choisie(Offres offre_choisie) {
		this.offre = offre_choisie;
	}
	
	
	
	public Offres getOffre() {
		return offre;
	}

	public void setOffre(Offres offre) {
		this.offre = offre;
	}

	public String getPemris() {
		return permis;
	}
	public void setPemris(String permis) {
		this.permis = permis;
	}
	public int getNbHeures() {
		return nbHeures;
	}
	public void setNbHeures(int nbHeures) {
		this.nbHeures = nbHeures;
	}
	public float getResultatCode() {
		return resultatCode;
	}
	public void setResultatCode(int resultatCode) {
		this.resultatCode = resultatCode;
	}
	public float getResultatPermis() {
		return resultatPermis;
	}
	public void setResultatPermis(float resultatPermis) {
		this.resultatPermis = resultatPermis;
	}
	
	
	
	
	
	
}
