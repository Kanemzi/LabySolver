package probleme;

public class Labyrinthe {
	private TypeCase cases[][];
	private int largeur, hauteur;
	
	public Labyrinthe(TypeCase cases[][], int largeur, int hauteur) {
		this.cases = cases;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}
	
	public int getHauteur() {
		return this.hauteur;
	}
	
	public int getLargeur() {
		return this.largeur;
	}
	
	public TypeCase getCase(int x, int y){
		return cases[y][x];
	}
}
