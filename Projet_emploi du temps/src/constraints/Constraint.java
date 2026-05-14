package constraints;

import java.util.Map;    //dico
import java.util.Set;    //liste sans doublons 



public interface Constraint {

	
	public Set<Activity> getActivities() ;
	
	public boolean isSatisfied (Map<Activity, Integer> date) ;

}
