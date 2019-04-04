package probleme;

import probleme.action.Deplacement;

/**
 * Probleme repr�sente un probl�me de r�solution de labyrinthe
 * 
 * Le probl�me est compos� du labyrinthe � r�soudre, des points d'entr�e et sortie du labyrinthe 
 * et des mouvements possibles pour l'objet se trouvant dans le labyrinthe
 *
 */
public class Probleme {
	private Labyrinthe laby;
	private Etat etatInitial, etatFinal;
	private Deplacement deplacements[];
	
	/**
	 * Cr�e un nouveau probl�me
	 * 
	 * @param laby le labyrinthe � r�soudre
	 * @param etatInitial l'�tat initial du probl�me (l'objet est � l'entr�e du labyrinthe)
	 * @param etatFinal l'�tat final du probl�me (l'objet est � la sortie du labyrinthe)
	 * @param deplacements les d�placements que l'objet peut �x�cuter dans le labyrinthe 
	 */
	public Probleme(Labyrinthe laby, Etat etatInitial, Etat etatFinal, Deplacement[] deplacements) {
		this.laby = laby;
		this.etatInitial = etatInitial;
		this.etatFinal = etatFinal;
		this.deplacements = deplacements;
	}

	/**
	 * Retourne le labyrinthe � r�soudre
	 * @return le labyrinthe � r�soudre
	 */
	public Labyrinthe getLaby() {
		return laby;
	}

	/**
	 * Retourne l'�tat initial du probl�me
	 * @return l'�tat initial du probl�me
	 */
	public Etat getEtatInitial() {
		return etatInitial;
	}
	
	/**
	 * Retourne l'�tat final du probl�me
	 * @return l'�tat final du probl�me
	 */
	public Etat getEtatFinal() {
		return etatFinal;
	}

	/**
	 * Retourne les diff�rents d�placements possibles dans le labyrinthe
	 * @return les d�placements possibles
	 */
	public Deplacement[] getDeplacements() {
		return deplacements;
	}
	
}
