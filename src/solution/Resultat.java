package solution;

import java.util.ArrayList;

import probleme.Probleme;

public class Resultat {
	private double time;
	private int etapes;
	private boolean found;
	private Noeud noeudFinal;
	private ArrayList<Noeud> chemin;
	private Probleme probleme;

	public Resultat(Probleme probleme, boolean found, double time, int etapes, Noeud noeudFinal) {
		this.probleme = probleme;
		this.noeudFinal = noeudFinal;
		this.found = found;
		this.time = time;
		this.etapes = etapes;
		this.chemin = getChemin(noeudFinal);
	}
	
	public ArrayList<Noeud> getChemin(Noeud nf) {
		while(nf.getParent() != null) {
			chemin.add(nf);
			nf = nf.getParent();
		}
		return chemin;
	}
	
	public int getLongueurChemin() {
		return chemin.size();
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public int getEtapes() {
		return etapes;
	}

	public void setEtapes(int etapes) {
		this.etapes = etapes;
	}
	
	public boolean isFound() {
		return found;
	}
	
	public Noeud getNoeudFinal() {
		return noeudFinal;
	}
	
	public String getResultatCSV() {
		return probleme.getLaby().getNom() + ";" + ;
	}
	
	public String toString() {
		String s = "";
		if (found) {
			s += "resolu ";
		} else {
			s += "non resolu ";
		}
		s += "en ";
		s += time + " secondes ( ";
		s += etapes + " )";
		
		return s;
	}
}