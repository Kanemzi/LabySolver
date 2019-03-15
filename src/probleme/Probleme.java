package probleme;

import probleme.action.Deplacement;

public class Probleme {
	Labyrinthe laby;
	Etat etatInitial, etatFinal;
	Deplacement deplacements[];
	
	public Probleme(Labyrinthe laby, Etat etatInitial, Etat etatFinal, Deplacement[] deplacements) {
		this.laby = laby;
		this.etatInitial = etatInitial;
		this.etatFinal = etatFinal;
		this.deplacements = deplacements;
	}
}
