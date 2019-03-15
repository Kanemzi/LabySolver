package probleme.action;

import probleme.Etat;

public class Deplacement implements Action {
	
	int cout;
	int depX, depY;
	
	public Deplacement(int depX, int depY) {
		this.depX = depX;
		this.depY = depY;
		this.cout = 1;
	}
	
	public void appliquer(Etat e) {
		return;
	}
	public boolean possible(Etat e) {
		return false;
	}
}
