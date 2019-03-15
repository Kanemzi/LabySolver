package probleme.action;

import probleme.Etat;

public interface Action {
	public void appliquer(Etat e);
	public boolean possible(Etat e);
}
