package solution;

import java.util.LinkedList;
import java.util.Queue;

import probleme.Probleme;

public class SolverExploLargeur implements Solver {
	
	private Queue<Noeud> frontiere;
	
	public Resultat resoudre(Probleme p) {
		frontiere = new LinkedList<>();
		
		// ajout de l'état initial
		frontiere.add(new Noeud(p.getEtatInitial(), null, null, 0, 0));
		
		boolean solutionFound = false;
		
		long startTime = System.currentTimeMillis();
		
		int etapes = 0;
		
		while (!solutionFound) {
			etapes ++;
			
			if (frontiere.isEmpty()) {
				return new Resultat(false, (double)(System.currentTimeMillis()-startTime)/1000.0, etapes, null);
			} else {
				Noeud n = frontiere.remove();
				if (n.getEtat().equals(p.getEtatFinal())) {
					return new Resultat(true, (double)(System.currentTimeMillis()-startTime)/1000.0, etapes, n);
				} else {
					frontiere.addAll(developper(n, p));
				}
			}
		}
		
		
		return null;
	}
}
