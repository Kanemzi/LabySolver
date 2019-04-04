package probleme;

/**
 * Labyrinthe repr�sente le labyrinthe charg� � partir du fichier
 */
public class Labyrinthe {
	private String nom;
	private TypeCase cases[][];
	private int largeur, hauteur;
	
	/**
	 * Cr�e un Labyrinthe � partir d'un tableau contenant ses diff�rents murs , sa largeur et sa hauteur
	 * 
	 * @param cases les murs et cases vides qui composent le labyrinthe
	 * @param largeur la largeur du labyrinthe
	 * @param hauteur la hauteur du labyrinthe
	 */
	public Labyrinthe(String nom, TypeCase cases[][], int largeur, int hauteur) {
		this.nom = nom;
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
	 * Retourne le nom du labyrinthe
	 * @return le nom du labyrinthe
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * Retourne l'ensemble des cases qui composent le labyrinthe
	 * @return les cases du labyrinthe
	 */
	public TypeCase[][] getCases() {
		return cases;
	}
	
	/**
	 * R�cup�re le contenu d'une case du labyrinthe
	 * 
	 * @param x la position x de la case � tester
	 * @param y la position y de la case � tester
	 * @return le contenu de la case aux coordonn�es indiqu�es
	 */
	public TypeCase getCase(int x, int y){
		return cases[y][x];
	}
}
