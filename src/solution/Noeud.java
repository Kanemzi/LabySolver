package solution;

import probleme.Etat;
import probleme.action.Deplacement;

public class Noeud {
	private double coutChemin;
	private int profondeur;
	private Etat etat;
	private Noeud parent;
	private Deplacement action;
	
	public Noeud(Etat etat, Noeud parent, Deplacement action, double coutChemin, int profondeur) {
		this.etat = etat;
		this.parent = parent;
		this.action = action;
		this.coutChemin = coutChemin;
		this.profondeur = profondeur;
	}

	public double getCoutChemin() {
		return coutChemin;
	}

	public int getProfondeur() {
		return profondeur;
	}

	public Etat getEtat() {
		return etat;
	}

	public Noeud getParent() {
		return parent;
	}

	public Deplacement getAction() {
		return action;
	}

	@Override
	public String toString() {
		return "Noeud [coutChemin=" + coutChemin + ", profondeur=" + profondeur + ", etat=" + etat + ", parent="
				+ parent + ", action=" + action + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Noeud other = (Noeud) obj;
		if (etat == null) {
			if (other.etat != null)
				return false;
		} else if (!etat.equals(other.etat))
			return false;
		return true;
	}

	
	
	
}
