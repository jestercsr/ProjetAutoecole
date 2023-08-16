public class Evenement {

	String titre;
	String date;
	String heure_deb;
	String heure_fin;
	Evenement(String a, String b,String c,String d) {
		this.titre=a;
		this.date=b;
		this.heure_deb=c;
		this.heure_fin=d;
	}
	
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHeure_deb() {
		return heure_deb;
	}

	public void setHeure_deb(String heure_deb) {
		this.heure_deb = heure_deb;
	}

	public String getHeure_fin() {
		return heure_fin;
	}

	public void setHeure_fin(String heure_fin) {
		this.heure_fin = heure_fin;
	}

}
