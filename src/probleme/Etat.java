package probleme;

import probleme.action.Deplacement;

/**
 * Etat représente un état du labyrinthe dans lequel se déplace un objet
 * Un état est composé du labyrinthe et des coordonnées de l'objet
 */
public class Etat {
	
	private int posX, posY;
	private Labyrinthe laby;
	
	/**
	 * Crée un nouvel état
	 * 
	 * @param laby le labyrinthe associé à l'état
	 * @param posX la position x de l'objet dans le labyrinthe
	 * @param posY la position y de l'objet dans le labyrinthe
	 */
	public Etat(Labyrinthe laby, int posX, int posY) {
		this.laby = laby;
		this.posX = posX;
		this.posY = posY;
	}
	
	/**
	 * Génére un nouvel état à partir d'un état et d'un déplacement de l'objet
	 * 
	 * @param dep le déplacement à effectuer
	 * @return le nouvel état après le déplacement, null si le déplacement est impossible
	 */
	public Etat faireDeplacement(Deplacement dep) {
		if (dep.possible(this)) {
			Etat e = new Etat(laby, posX, posY);
			dep.appliquer(e);
			return e;
		}
		return null;
	}

	/**
	 * Permet de connaître la position horizontale de l'objet dans le labyrinthe
	 * @return la position x de l'objet
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * Modifie la position horizontale de l'objet dans le labyrinthe
	 * @param posX la nouvelle position x de l'objet
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * Permet de connaétre la position verticale de l'objet dans le labyrinthe
	 * @return la position y de l'objet
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * Modifie la position verticale de l'objet dans le labyrinthe
	 * @param posY la nouvelle position y de l'objet
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * Permet de récupérer le labyrinthe associé à l'état
	 * @return le labyrinthe associé à l'état
	 */
	public Labyrinthe getLaby() {
		return laby;
	}

	/**
	 * Teste l'égalité entre deux états.
	 * Deux états sont égaux si la position des objets est identique et si leur labyrinthe a la même référence.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etat other = (Etat) obj;
		if (laby == null) {
			if (other.laby != null)
				return false;
		} else if (laby != other.laby)
			return false;
		if (posX != other.posX)
			return false;
		if (posY != other.posY)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "(" +posX + ","+ posY + ")";
	}
	
	
}
