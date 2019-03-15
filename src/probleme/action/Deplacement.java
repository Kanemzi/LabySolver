package probleme.action;

import probleme.Etat;
import probleme.TypeCase;

/**
 * Deplacement représente une action pouvant être éxécutée dans le labyrinthe
 * ces actions permettent de modifier les coordonnées de l'objet se trouvant dans le labyrinthe
 */
public class Deplacement implements Action {
	
	private int cout;
	private int depX, depY;
	
	/**
	 * Crée un nouveau déplacement possible
	 * @param depX la modification en x des coordonnées de l'objet
	 * @param depY la modification en y des coordonnées de l'objet
	 */
	public Deplacement(int depX, int depY) {
		this.depX = depX;
		this.depY = depY;
		this.cout = 1;
	}
	
	/**
	 * Applique le déplacement à l'objet d'un état 
	 * 
	 * @param e l'état sur lequel appliquer le mouvement
	 */
	public void appliquer(Etat e) {
		e.setPosX(e.getPosX() + depX);
		e.setPosY(e.getPosY() + depY);
	}
	
	/**
	 * Permet de savoir si un déplacement est possible pour un état donné
	 * @param e l'état à tester pour le mouvement
	 * @return true si le déplacement est possible, false sinon
	 */
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
