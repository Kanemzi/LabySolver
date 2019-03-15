package solution;

public class Noeud {
	private int coutChemin;
	private int profondeur;
	
	public Noeud(int coutChemin, int profondeur) {
		this.coutChemin = coutChemin;
		this.profondeur = profondeur;
	}

	public int getCoutChemin() {
		return coutChemin;
	}

	public void setCoutChemin(int coutChemin) {
		this.coutChemin = coutChemin;
	}

	public int getProfondeur() {
		return profondeur;
	}

	public void setProfondeur(int profondeur) {
		this.profondeur = profondeur;
	}
}
