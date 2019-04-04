package solution;

import java.util.ArrayList;

import probleme.Probleme;
import java.util.Collections;
import java.util.List;


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
		this.chemin = getCheminByNoeudFinal(noeudFinal);
	}
	
	public static ArrayList<Noeud> getCheminByNoeudFinal(Noeud nf) {
		
		if (nf == null) return null;
		
		ArrayList<Noeud> chemin = new ArrayList<>();
		while(nf.getParent() != null) {
			chemin.add(nf);
			nf = nf.getParent();
		}
		chemin.add(nf);
		Collections.reverse(chemin);
		return chemin;
	}
	
	public ArrayList<Noeud> getChemin() {
		return this.chemin;
	}
	
	public String getCheminToString() {
		
		if (chemin == null) return "aucun chemin";
		
		String cs = "";
		for (int i = 1; i < getChemin().size(); i++) {
			cs +=getChemin().get(i).getAction().toString();
			if(i<getChemin().size()-1) {
				cs+="->";
			}
		}
		return cs;
	}
	
	public int getLongueurChemin() {
		if (chemin == null) return 0;
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
	
	public String getResultatCSV() {
		return probleme.getLaby().getNom() + ";" + etapes + ";" + getLongueurChemin() + ";" + getCheminToString();
	}
	
	public String toString() {
		String s = "";
		if (found) {
			s += "resolu ";
			s += "en ";
			s += time + " secondes ( ";
			s += etapes + " étape éffectuées )\n";
			s += "les �tats parcouru sont    : ";
			for (int i = 0; i < getChemin().size(); i++) {
				s +=getChemin().get(i).getEtat().toString();
				if(i<getChemin().size()-1) {
					s+=" -> ";
				}else {
					s+="\n";
				}
			}
			s += "les actions effectuées sont : ";
			s += getCheminToString();
		} else {
			s += "aucun chemin";
		}
		
		return s;
	}
}