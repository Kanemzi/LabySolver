package application;

import probleme.GenerateurProbleme;
import probleme.Probleme;
import probleme.TypeCase;
import solution.Noeud;
import solution.Resultat;
import solution.Solver;
import solution.SolverExploLargeur;
import solution.SolverExploProfondeur;

public class Application {
	public static void main(String[] args) {
		Probleme p = GenerateurProbleme.generer("labs/labExemple.lab");
		
		TypeCase[][] cs = p.getLaby().getCases();
		
		for(TypeCase[] c : cs) {
			for(TypeCase t : c) {
				System.out.print(t + "\t");
			}
			System.out.println();
		}
		
		System.out.println(p.getEtatInitial().getPosX() + " " + p.getEtatInitial().getPosY());
		System.out.println(p.getEtatFinal().getPosX() + " " + p.getEtatFinal().getPosY());
		
		System.out.println(p.getLaby().getHauteur() + " " + p.getLaby().getLargeur());
		
		// LARGEUR
		System.out.println("\n\n\nExploration en largeur : \n");
		Solver s2 = new SolverExploLargeur();
		long time = System.nanoTime();
		Resultat r2 = s2.resoudre(p);
		
		// affichage de stats sur le résultat
		System.out.println("etapes :" + r2.getEtapes());
		System.out.println("time : " + (System.nanoTime() - time));
		
		Noeud n = r2.getNoeudFinal();
		while(n.getParent() != null) {
			System.out.println(n.getEtat().getPosX() + ", " + n.getEtat().getPosY());
			n = n.getParent();
		}
		System.out.println(n.getEtat().getPosX() + ", " + n.getEtat().getPosY());
		
		// PROFONDEUR
		System.out.println("\n\n\nExploration en profondeur : \n");
		Solver s = new SolverExploProfondeur();
		time = System.nanoTime();
		Resultat r = s.resoudre(p);
		
		// affichage de stats sur le résultat
		System.out.println("etapes :" + r.getEtapes());
		System.out.println("time : " + (System.nanoTime() - time));
		
		n = r.getNoeudFinal();
		while(n.getParent() != null) {
			System.out.println(n.getEtat().getPosX() + ", " + n.getEtat().getPosY());
			n = n.getParent();
		}
		System.out.println(n.getEtat().getPosX() + ", " + n.getEtat().getPosY());
		
		
	}
}
