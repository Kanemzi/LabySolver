package probleme;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import probleme.action.Deplacement;

public class GenerateurProbleme {
	
	/**
	 * Parse un fichier .lab pour générer le labyrinthe correspondant et un problème lié aux points d'entrée et sortie de ce labyrinthe
	 * @param file un fichier .lab à résoudre
	 * @return le problème correspondant au labyrinthe
	 */
	public static Probleme generer(String file) {
		File f = new File(file);
		Scanner sc = null;
		
		ArrayList<String> lines = new ArrayList<>();
		
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(sc.hasNextLine()) {
			lines.add(sc.nextLine());
		}

		int largeur, hauteur;
		
		largeur = lines.get(0).length();
		hauteur = lines.size();
		
		TypeCase cases[][] = new TypeCase[hauteur][largeur] ;
		
		// points d'entrée et sortie
		int ex = 0, ey = 0, sx = 0, sy = 0;
		
		for (int y = 0; y < hauteur; y++) {
			char[] cs = lines.get(y).toCharArray();
			for (int x = 0; x < largeur; x++) {
				char c = cs[x];
				switch(c) {
				case 'M' :
					cases[y][x] = TypeCase.mur;
					break;
				
				case '_' :
					cases[y][x] = TypeCase.vide;
					break;
				
				case 'E' :
					ex = x; 
					ey = y;
					cases[y][x] = TypeCase.vide;
					break;
				
				case 'S' :
					sx = x; 
					sy = y;
					cases[y][x] = TypeCase.vide;
					break;
				}
			}
		}
		
		Labyrinthe laby = new Labyrinthe(cases, largeur, hauteur);
		Etat etatInitial = new Etat(laby, ex, ey);
		Etat etatFinal = new Etat(laby, sx, sy);
		
		Probleme p = new Probleme(laby, etatInitial, etatFinal, getDeplacements());
				
		return p;
	}
	
	/**
	 * Donne la liste des déplacements autorisés pour la résolution des labyrinthes
	 * @return la liste des déplacements
	 */
	public static Deplacement[] getDeplacements() {
		Deplacement[] deps = new Deplacement[4];
		
		deps[0] = new Deplacement(0, -1); // haut
		deps[1] = new Deplacement(0, 1); // bas
		deps[2] = new Deplacement(-1, 0); // gauche
		deps[3] = new Deplacement(1, 0); // droite
		
		return deps;
	}
}
