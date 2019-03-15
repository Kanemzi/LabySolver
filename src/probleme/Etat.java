package probleme;

import probleme.action.Deplacement;

public class Etat {
	
	private int posX, posY;
	private Labyrinthe laby;
	
	public Etat(Labyrinthe laby, int posX, int posY) {
		this.laby = laby;
		this.posX = posX;
		this.posY = posY;
	}
	
	public Etat faireDeplacement(Deplacement dep) {
		Etat e = new Etat(laby, posX, posY);
		dep.appliquer(e);
		return e;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public Labyrinthe getLaby() {
		return laby;
	}

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
