package probleme.action;

import probleme.Etat;

/**
 * Action repr�sente une action possible pouvant �tre �x�cut�e dans le but de r�soudre un probl�me
 */
public abstract class Action {
	protected String nom;
	protected int cout;
	
	public Action(String nom, int cout) {
		this.nom = nom;
		this.cout = cout;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getCout() {
		return cout;
	}
	
	public abstract void appliquer(Etat e);
	public abstract boolean possible(Etat e);
}
