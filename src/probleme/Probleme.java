package probleme;

import probleme.action.Deplacement;

/**
 * Probleme représente un problème de résolution de labyrinthe
 * 
 * Le problème est composé du labyrinthe à résoudre, des points d'entrée et sortie du labyrinthe 
 * et des mouvements possibles pour l'objet se trouvant dans le labyrinthe
 *
 */
public class Probleme {
	private Labyrinthe laby;
	private Etat etatInitial, etatFinal;
	private Deplacement deplacements[];
	
	/**
	 * Crée un nouveau problème
	 * 
	 * @param laby le labyrinthe à résoudre
	 * @param etatInitial l'état initial du problème (l'objet est à l'entrée du labyrinthe)
	 * @param etatFinal l'état final du problème (l'objet est à la sortie du labyrinthe)
	 * @param deplacements les déplacements que l'objet peut éxécuter dans le labyrinthe 
	 */
	public Probleme(Labyrinthe laby, Etat etatInitial, Etat etatFinal, Deplacement[] deplacements) {
		this.laby = laby;
		this.etatInitial = etatInitial;
		this.etatFinal = etatFinal;
		this.deplacements = deplacements;
	}

	/**
	 * Retourne le labyrinthe à résoudre
	 * @return le labyrinthe à résoudre
	 */
	public Labyrinthe getLaby() {
		return laby;
	}

	/**
	 * Retourne l'état initial du problème
	 * @return l'état initial du problème
	 */
	public Etat getEtatInitial() {
		return etatInitial;
	}
	
	/**
	 * Retourne l'état final du problème
	 * @return l'état final du problème
	 */
	public Etat getEtatFinal() {
		return etatFinal;
	}

	/**
	 * Retourne les différents déplacements possibles dans le labyrinthe
	 * @return les déplacements possibles
	 */
	public Deplacement[] getDeplacements() {
		return deplacements;
	}
	
}
