package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import probleme.Probleme;

public class SolverExploProfondeur implements Solver{
	
	private List<Noeud> frontiere;
	
	public Resultat resoudre(Probleme p) {
		
	
		frontiere = new ArrayList<>();
		
		// ajout de l'Ã©tat initial
		frontiere.add(new Noeud(p.getEtatInitial(), null, null, 0, 0));
		
		
		boolean solutionFound = false;
		
		long startTime = System.currentTimeMillis();
		
		int etapes = 0;
		int tmp = 1;
		while (!solutionFound) {
			etapes ++;
			if(frontiere.isEmpty()) {
				return new Resultat(false, (double)(System.currentTimeMillis()-startTime)/1000.0, etapes, null);
			}else {
				Noeud n = frontiere.remove(frontiere.size()-tmp);
				if (n.getProfondeur()>= 50) {	// condition pour évider de tourné en rond
					// ne rien faire avec le noeud
				}else { // continue a explorer le noeud
					if (n.getEtat().equals(p.getEtatFinal())) {
						return new Resultat(true, (double)(System.currentTimeMillis()-startTime)/1000.0, etapes, n);
					} else {
						frontiere.addAll(developper(n, p));
					}
				}
			}
		}
		return null;
		
	}
}
