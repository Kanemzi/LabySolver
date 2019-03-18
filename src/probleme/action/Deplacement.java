package probleme.action;

import probleme.Etat;
import probleme.TypeCase;

/**
 * Deplacement repr�sente une action pouvant �tre �x�cut�e dans le labyrinthe
 * ces actions permettent de modifier les coordonn�es de l'objet se trouvant dans le labyrinthe
 */
public class Deplacement implements Action {
	
	private int cout;
	private int depX, depY;
	
	/**
	 * Cr�e un nouveau d�placement possible
	 * @param depX la modification en x des coordonn�es de l'objet
	 * @param depY la modification en y des coordonn�es de l'objet
	 */
	public Deplacement(int depX, int depY) {
		this.depX = depX;
		this.depY = depY;
		this.cout = 1;
	}
	
	/**
	 * Applique le d�placement � l'objet d'un �tat 
	 * 
	 * @param e l'�tat sur lequel appliquer le mouvement
	 */
	public void appliquer(Etat e) {
		e.setPosX(e.getPosX() + depX);
		e.setPosY(e.getPosY() + depY);
	}
	
	/**
	 * Permet de savoir si un d�placement est possible pour un �tat donn�
	 * @param e l'�tat � tester pour le mouvement
	 * @return true si le d�placement est possible, false sinon
	 */
	public boolean possible(Etat e) {
		
		int nx = e.getPosX() + depX,
			ny = e.getPosY() + depY;
		
		boolean okBords = nx >= 0
					&& ny >= 0
					&& nx < e.getLaby().getLargeur()
					&& ny < e.getLaby().getHauteur();
		
		if (! okBords) return false;			
		
		boolean okMur = e.getLaby().getCase(nx, ny) != TypeCase.mur;
		
		return okMur;
	}
	
	public int getCout() {
		return cout;
	}
}
