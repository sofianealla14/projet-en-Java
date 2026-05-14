package constraints;

import java.util.Map;
import java.util.Set;

public class MaxSpanConstraint implements Constraint{
    public Set<Activity> sActivity ; //  ensemble d'activitees
    public int tempsmax; // duree maximum autorise de type int
    
    
    public MaxSpanConstraint(Set<Activity> sActivity, int tempsmax) {  //constructeur
        this.sActivity = sActivity;
        this.tempsmax = tempsmax;
    }
    public boolean isSatisfied(Map<Activity,Integer> map) {
        int minDepart = Integer.MAX_VALUE;
        int finDerniereActivity = Integer.MIN_VALUE;
        
        if(sActivity ==null || sActivity.size()==0) {   //si la liste est  vide
        	return true;
        }
      
        for (Activity activity : map.keySet()){
            if (sActivity.contains(activity)) {
                if (map.get(activity)<minDepart){
                    minDepart=map.get(activity);
                }
                if (map.get(activity)+activity.getDuration()>finDerniereActivity){
                	finDerniereActivity=map.get(activity)+activity.getDuration();
                }
            }
        }
		if (finDerniereActivity-minDepart<=this.tempsmax){
            return true;
        }
        return false;
    }
		
	public Set<Activity> getActivities() {
		return this.sActivity;
	}
	
	
	
	
	
	
}
        
	