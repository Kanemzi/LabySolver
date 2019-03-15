package probleme.action;

import probleme.Etat;

/**
 * Action représente une action possible pouvant être éxécutée dans le but de résoudre un problème
 */
public interface Action {
	public void appliquer(Etat e);
	public boolean possible(Etat e);
}
