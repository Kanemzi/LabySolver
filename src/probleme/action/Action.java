package probleme.action;

import probleme.Etat;

/**
 * Action repr�sente une action possible pouvant �tre �x�cut�e dans le but de r�soudre un probl�me
 */
public abstract class Action {
	
	private String nom;
	public Action(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	
	@Override
	public String toString() {
		return nom;
	}
	
	public abstract void appliquer(Etat e);
	public abstract boolean possible(Etat e);
}
