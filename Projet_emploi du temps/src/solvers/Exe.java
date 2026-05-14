package solvers;


import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import constraints.Activity;
import constraints.Constraint;
import constraints.MaxSpanConstraint;
import constraints.MeetConstraint;
import constraints.PrecedenceConstraint;

public class Exe {
	
	public static void main (String[] args) {
		
		Activity act1 = new Activity ("se brosser les dents",5);
		Activity act2 = new Activity ("bus",25);
		Activity act3 = new Activity ("math",40);
		Activity act4 = new Activity ("manger",30);
		Activity act5 = new Activity ("reviser",50);
		Activity act6 = new Activity ("loisir",55);
		Activity act7 = new Activity ("dormir",60);
		
		Set<Activity> setAct = new HashSet<>();
		
		setAct.add(act1);
		setAct.add(act2);
		setAct.add(act3);
		setAct.add(act4);
		setAct.add(act5);
		setAct.add(act6);
		setAct.add(act7);
		
		RandomScheduler rand = new RandomScheduler(new Random());
		Set<Constraint> setCons = new HashSet<>();
		
		// PRECEDENCE CONTRAINTE	
		
		
		System.out.println("PRECEDENCE CONTRAINTE :");
		
		
		
		setCons.add(new PrecedenceConstraint(act1 , act2)); //on se brosse les dents avant d'aller prednre le bus 
		setCons.add(new PrecedenceConstraint(act2 , act3)); //on prend le bus avant d'aller en cours
		setCons.add(new PrecedenceConstraint(act3 , act4)); //on va au cours de math avant d'aller manger
		setCons.add(new PrecedenceConstraint(act4 , act5)); //on mange avant d'aller reviser
		setCons.add(new PrecedenceConstraint(act5 , act6)); //on revise avant ses loisir
		setCons.add(new PrecedenceConstraint(act6 , act7)); //avant d'aller dormir on fini ses loisirs
		
		
		
		
		Map<Activity, Integer> map= rand.generateSchedule(setAct, setCons, 0,400, 10000);
		System.out.println(map);
		
		System.out.println("");
		
		Map<Activity, Integer> map2= rand.generateSchedule(setAct, setCons, 0,400, 1000000); // plus long mais donne un meilleur emploie du temps
		System.out.println(map2);
		
		System.out.println("");
		
		
		// MEET CONTRAINT
		
		
		System.out.println("MEET CONTRAINT :");
		
		Set<Constraint> setCons2 = new HashSet<>();
		
		setCons2.add(new MeetConstraint(act1 , act2));
		
		Map<Activity, Integer> map3= rand.generateSchedule(setAct, setCons, 0,400, 100000);
		System.out.println(map3);
		
		System.out.println("");
		
		
		
		//MaxSpanConstraint
		
		// permettant de représenter des contraintes stipulant que pour un ensemble d'activités données, il ne doit pas s'écouler 
		//plus d'un nombre donné d'unités de temps entre le moment où la première commence et celui où la dernière se termine
		
		
		System.out.println("MaxSpanConstraint:");
		
		Set<Constraint> setCons3 = new HashSet<>();
		
		setCons3.add(new MaxSpanConstraint(setAct , 500));
		
		Map<Activity, Integer> map4= rand.generateSchedule(setAct, setCons, 0,400, 10000);
		System.out.println(map4);
	}

}
