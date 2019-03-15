package probleme;

/**
 * Labyrinthe représente le labyrinthe chargé à partir du fichier
 */
public class Labyrinthe {
	private TypeCase cases[][];
	private int largeur, hauteur;
	
	/**
	 * Crée un Labyrinthe à partir d'un tableau contenant ses différents murs , sa largeur et sa hauteur
	 * 
	 * @param cases les murs et cases vides qui composent le labyrinthe
	 * @param largeur la largeur du labyrinthe
	 * @param hauteur la hauteur du labyrinthe
	 */
	public Labyrinthe(TypeCase cases[][], int largeur, int hauteur) {
		this.cases = cases;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}
	
	/**
	 * Retourne la hauteur du labyrinthe
	 * @return la hauteur du labyrinthe
	 */
	public int getHauteur() {
		return this.hauteur;
	}
	
	/**
	 * Retourne la largeur du labyrinthe
	 * @return la largeur du labyrinthe
	 */
	public int getLargeur() {
		return this.largeur;
	}
	
	/**
	 * Retourne l'ensemble des cases qui composent le labyrinthe
	 * @return les cases du labyrinthe
	 */
	public TypeCase[][] getCases() {
		return cases;
	}
	
	/**
	 * Récupère le contenu d'une case du labyrinthe
	 * 
	 * @param x la position x de la case à tester
	 * @param y la position y de la case à tester
	 * @return le contenu de la case aux coordonnées indiquées
	 */
	public TypeCase getCase(int x, int y){
		return cases[y][x];
	}
}
