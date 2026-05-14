package solvers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import constraints.Activity;
import constraints.PrecedenceConstraint;

public class TopologicalSorter {

	public TopologicalSorter() { // constructeur sans argument donc fait rien directement en soit

	}

	public ArrayList<Activity> bruteForceSort(HashSet<Activity> lstActivity,
			HashSet<PrecedenceConstraint> PrecedenceConstraint) {

		ArrayList<Activity> newListAct = new ArrayList<Activity>(); // initialiser
		ArrayList<Activity> copyLstActctivity = new ArrayList<Activity>(lstActivity); // fait une copie

		boolean ok, continuer;

		while (copyLstActctivity.size() > 0) {
			continuer = false;
			for (Activity act : copyLstActctivity) {

				ok = true;

				for (PrecedenceConstraint constraints : PrecedenceConstraint) {

					if (constraints.getSecond() == act && !newListAct.contains(constraints.getFirst())) {
						ok = false;
					}
				}

				if (ok) {
					newListAct.add(act);
					copyLstActctivity.remove(act);
					continuer = true;
					break;
				}
			}
			if (continuer == false) {
				return null;
			}

		}
		return newListAct;
	}

	public HashMap<Activity, Integer> schedule(HashSet<Activity> lstActivity,
			HashSet<PrecedenceConstraint> lstConstraints) {

		HashMap<Activity, Integer> res = new HashMap<Activity, Integer>();
		ArrayList<Activity> Act = bruteForceSort(lstActivity, lstConstraints);

		if (Act == null)
			return null;

		Integer valeur;
		valeur = 0;
		for (Activity a : Act) {
			res.put(a, valeur);
			valeur = valeur + a.getDuration();
		}
		return res;
	}
}
