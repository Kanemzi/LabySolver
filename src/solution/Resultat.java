package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Resultat {
	private double time;
	private int etapes;
	private boolean found;
	private Noeud noeudFinal;
	private ArrayList<Noeud> chemin;

	public Resultat(boolean found, double time, int etapes, Noeud noeudFinal) {
		this.noeudFinal = noeudFinal;
		this.found = found;
		this.time = time;
		this.etapes = etapes;
		this.chemin = new ArrayList<Noeud>();
	}
	
	public ArrayList<Noeud> getChemin() {
		chemin.clear();
		Noeud n = noeudFinal;
		while(n.getParent() != null) {
			chemin.add(n);
			n = n.getParent();
		}
		chemin.add(n);
		Collections.reverse(chemin);
		return chemin;
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
	
	
	public String toString() {
		String s = "";
		if (found) {
			s += "resolu ";
			s += "en ";
			s += time + " secondes ( ";
			s += etapes + " étape éffectué )\n";
			s += "les états parcouru sont    : ";
			for (int i = 0; i < getChemin().size(); i++) {
				s +=getChemin().get(i).getEtat().toString();
				if(i<getChemin().size()-1) {
					s+=" -> ";
				}else {
					s+="\n";
				}
			}
			s += "les actions affectuez sont : ";
			for (int i = 1; i < getChemin().size(); i++) {
				s +=getChemin().get(i).getAction().toString();
				if(i<getChemin().size()-1) {
					s+=" -> ";
				}
			}
		} else {
			s += "non resolu ";
		}
		
		return s;
	}
}