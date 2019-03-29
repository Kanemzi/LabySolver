package application;

import java.io.FileNotFoundException;
import java.util.Scanner;

import probleme.GenerateurProbleme;
import probleme.Probleme;
import probleme.TypeCase;
import solution.Heuristique;
import solution.Resultat;
import solution.Solver;
import solution.SolverAstar;
import solution.SolverExploLargeur;
import solution.SolverExploProfondeur;

public class Application {
	public static void main(String[] args) throws FileNotFoundException {
		int type = 0;
		String lab = " ";
		System.out.println("Indiquez le chemin du lab que vous voulez rÈsoudre");
		System.out.println("Ou Ècrivez quit pour QUITTER");
		System.out.print("|->");
		
		@SuppressWarnings("resource")
		Scanner sc1 = new Scanner(System.in);
		lab = sc1.nextLine();
		
		while (type != 5 && !lab.equals("quit")) {
			
			Probleme p = GenerateurProbleme.generer(lab);
			
			TypeCase[][] cs = p.getLaby().getCases();
			
			for(TypeCase[] c : cs) {
				for(TypeCase t : c) {
					System.out.print(t + "\t");
				}
				System.out.println();
			}
			// affichage des coordonnÈes la position initial
			System.out.println(p.getEtatInitial().getPosX() + " " + p.getEtatInitial().getPosY());
			// affichage des coordonnÈes la position final
			System.out.println(p.getEtatFinal().getPosX() + " " + p.getEtatFinal().getPosY());
			// affichage de la taille du lab
			System.out.println(p.getLaby().getHauteur() + " " + p.getLaby().getLargeur());
			// scanner permettant de savoir le type de rÈsolution
			System.out.println("Type de rÈsolution\n");
			System.out.println("  |-> 1 rÈsolution en largeur");
			System.out.println("  |-> 2 rÈsolution en longueur");
			System.out.println("  |-> 3 rÈsolution avec astar");
			System.out.println("  |-> 4 rÈsolution avec tous");
			System.out.println("  |-> 5 pour QUITTER");
			System.out.println("_______________________________");
			System.out.print("A vous de jouer : ");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
		    type = sc.nextInt();
	
			//========================================= LARGEUR ===============================================
			if (type == 1 || type == 4) {
				System.out.println("\n\n\nExploration en largeur : \n");
				Solver s2 = new SolverExploLargeur();
				long time = System.nanoTime();
				Resultat r2 = s2.resoudre(p);
				
				// affichage de stats sur le r√©sultat
				System.out.println("etapes :" + r2.getEtapes());
				System.out.println("time : " + (System.nanoTime() - time));
				System.out.println(r2);
			}
			
			
			//========================================= PROFONDEUR ================================================
			else if (type == 2 || type == 4) {
				System.out.println("\n\n\nExploration en profondeur : \n");
	
				Solver s = new SolverExploProfondeur();
				long time = System.nanoTime();
				Resultat r = s.resoudre(p);
				// affichage de stats sur le r√©sultat
				System.out.println("etapes :" + r.getEtapes());
				System.out.println("time : " + (System.nanoTime() - time));
				System.out.println(r);
			}
			
			
			//=========================================== Astar	=================================================
			else if (type == 2 || type ==4) {
				System.out.println("\n\n\nExploration en A* : \n");
				Heuristique h = (pb, e) -> {
					int x = e.getPosX();
					int y = e.getPosY();
					int sx = pb.getEtatFinal().getPosX();
					int sy = pb.getEtatFinal().getPosY();
					
					int dx = (sx - x), dy = (sy - y);
					
					return dx * dx + dy * dy;
					
					//return Math.abs(sx - x) + Math.abs(sy - y);
				};
				Solver sat = new SolverAstar(h);
				long time = System.nanoTime();
				Resultat r3 = sat.resoudre(p);
	
				// affichage de stats sur le r√©sultat
				System.out.println("etapes :" + r3.getEtapes());
				System.out.println("time : " + (System.nanoTime() - time));
				System.out.println(r3);
			}
			else {
				// relancer la boucle 
			}
		}
	}
}
