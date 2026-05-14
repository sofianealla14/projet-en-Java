package constraints;

import java.util.HashSet;   //pour Implémentations 
import java.util.Map;   //dico
import java.util.Set;   //liste sans doublons

public abstract class BinaryConstraint implements Constraint {
	
	protected Activity act1;
	protected Activity act2;
	
	public BinaryConstraint (Activity act1, Activity act2) {
		this.act1 = act1;
		this.act2 = act2;
	}
	
	public Activity getFirst() {
		return this.act1;
	}

	public Activity getSecond() {
		return this.act2;
	}
	
	public abstract boolean isSatisfied (int d1, int d2); 

	
	public Set<Activity> getActivities() {
		Set<Activity> getActivities = new HashSet<Activity>();   //initialiser 
		getActivities.add(act1);  //implementer
		getActivities.add(act2);
		return getActivities;
	}

	public boolean isSatisfied(Map<Activity, Integer> dico ) {// utiliser Map<Activity, Integer> date pour faire appel au isSatisfied
		int d1 = dico.get(act1); //premet de récup integer (d1) de act1 
		int d2 = dico.get(act2);
		return isSatisfied(d1,d2);
		
	}

}
