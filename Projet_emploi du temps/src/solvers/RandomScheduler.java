package solvers;

import java.util.Random;
import java.util.Set;
import constraints.Activity;
import constraints.Constraint;
import java.util.HashMap;
import java.util.Map;


public class RandomScheduler {
	
	private Random alea;
	private int k ;
	
	
	public RandomScheduler(Random alea) {
		this.alea=alea;
	}
	
	public Map<Activity, Integer> generateOneSchedule(Set<Activity>setActivity, int dateMin, int dateMax){
		
		Map<Activity, Integer> map= new HashMap<>();
		for(Activity act : setActivity) {
			int random= alea.nextInt(dateMax - dateMin +1) + dateMin;  //génère un nombre uniformément situé entre datemin et datemax -1 c'est pour cela qu'on rajoute +1
			map.put(act,  random);
		}
		return map;
		}
		
	public Map<Activity, Integer> generateSchedule (Set<Activity> setAct, Set<Constraint> setCons, int dateMin, int dateMax, int nbTirage){
		
		Map<Activity, Integer> meilleurSchedule,schedule;
		meilleurSchedule = generateOneSchedule (setAct, dateMin, dateMax);
		Verifier verif = new Verifier(setCons);
		
		k=0;
		while( k < nbTirage) {
			k++;
			schedule = generateOneSchedule(setAct, dateMin, dateMax);
			if (verif.unsatisfied(schedule).size()< verif.unsatisfied(meilleurSchedule).size()) {
				meilleurSchedule = schedule;
			}
		}
		
		System.out.println(verif.unsatisfied(meilleurSchedule));
		return meilleurSchedule ;
		
	}
		
}
		
		

	
	
	

