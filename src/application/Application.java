package application;

import probleme.GenerateurProbleme;
import probleme.Probleme;
import probleme.TypeCase;

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
	}
}
