package probleme.action;

import probleme.Etat;

/**
 * Action repr�sente une action possible pouvant �tre �x�cut�e dans le but de r�soudre un probl�me
 */
public interface Action {
	public void appliquer(Etat e);
	public boolean possible(Etat e);
}
