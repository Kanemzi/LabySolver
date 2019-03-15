package probleme;

import probleme.action.Deplacement;

/**
 * Etat repr�sente un �tat du labyrinthe dans lequel se d�place un objet
 * Un �tat est compos� du labyrinthe et des coordonn�es de l'objet
 */
public class Etat {
	
	private int posX, posY;
	private Labyrinthe laby;
	
	/**
	 * Cr�e un nouvel �tat
	 * 
	 * @param laby le labyrinthe associ� � l'�tat
	 * @param posX la position x de l'objet dans le labyrinthe
	 * @param posY la position y de l'objet dans le labyrinthe
	 */
	public Etat(Labyrinthe laby, int posX, int posY) {
		this.laby = laby;
		this.posX = posX;
		this.posY = posY;
	}
	
	/**
	 * G�n�re un nouvel �tat � partir d'un �tat et d'un d�placement de l'objet
	 * 
	 * @param dep le d�placement � effectuer
	 * @return le nouvel �tat apr�s le d�placement, null si le d�placement est impossible
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
	 * Permet de conna�tre la position horizontale de l'objet dans le labyrinthe
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
	 * Permet de conna�tre la position verticale de l'objet dans le labyrinthe
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
	 * Permet de r�cup�rer le labyrinthe associ� � l'�tat
	 * @return le labyrinthe associ� � l'�tat
	 */
	public Labyrinthe getLaby() {
		return laby;
	}

	/**
	 * Teste l'�galit� entre deux �tats.
	 * Deux �tats sont �gaux si la position des objets est identique et si leur labyrinthe a la m�me r�f�rence.
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
}
