package application;

import probleme.GenerateurProbleme;
import probleme.Probleme;
import probleme.TypeCase;
import solution.Noeud;
import solution.Resultat;
import solution.Solver;
import solution.SolverExploLargeur;

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
		
		Solver s = new SolverExploLargeur();
		Resultat r = s.resoudre(p);
		
		Noeud n = r.getNoeudFinal();
		while(n.getParent() != null) {
			System.out.println(n.getEtat().getPosX() + ", " + n.getEtat().getPosY());
			n = n.getParent();
		}
	}
}
