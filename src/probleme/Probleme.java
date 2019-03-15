package probleme;

import probleme.action.Deplacement;

public class Probleme {
	private Labyrinthe laby;
	private Etat etatInitial, etatFinal;
	private Deplacement deplacements[];
	
	public Probleme(Labyrinthe laby, Etat etatInitial, Etat etatFinal, Deplacement[] deplacements) {
		this.laby = laby;
		this.etatInitial = etatInitial;
		this.etatFinal = etatFinal;
		this.deplacements = deplacements;
	}

	public Labyrinthe getLaby() {
		return laby;
	}

	public Etat getEtatInitial() {
		return etatInitial;
	}
	
	public Etat getEtatFinal() {
		return etatFinal;
	}

	public Deplacement[] getDeplacements() {
		return deplacements;
	}
	
}
