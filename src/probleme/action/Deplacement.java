package probleme.action;

import probleme.Etat;
import probleme.TypeCase;

public class Deplacement implements Action {
	
	private int cout;
	private int depX, depY;
	
	public Deplacement(int depX, int depY) {
		this.depX = depX;
		this.depY = depY;
		this.cout = 1;
	}
	
	public void appliquer(Etat e) {
		e.setPosX(e.getPosX() + depX);
		e.setPosY(e.getPosY() + depY);
	}
	public boolean possible(Etat e) {
		
		int nx = e.getPosX() + depX,
			ny = e.getPosY() + depY;
		
		boolean okBords = nx >= 0
					&& ny >= 0
					&& nx < e.getLaby().getLargeur()
					&& ny < e.getLaby().getHauteur();
					
		boolean okMur = e.getLaby().getCase(nx, ny) != TypeCase.mur;
		
		return okBords && okMur;
	}
}
