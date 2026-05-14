package constraints;

public class Main {
	public static void main(String[] args) {
		
		Activity act1 = new Activity("courir",20);
		Activity act2 = new Activity("étudier",5);
		Activity act3 = new Activity("manger",25);
		Activity act4 = new Activity("jouer",50);
		
		PrecedenceConstraint constraint1 = new PrecedenceConstraint(act2,act1);
		System.out.println(constraint1.isSatisfied(0,10));
		
		PrecedenceConstraint constraint2 = new PrecedenceConstraint(act2,act1);
		System.out.println(constraint2.isSatisfied(11,15));
		
		MeetConstraint constraint3 = new MeetConstraint(act3,act4);
		System.out.println(constraint3.isSatisfied(0,10));
		
		MeetConstraint constraint4 = new MeetConstraint(act3,act4);
		System.out.println(constraint4.isSatisfied(0,25));
		
	}

}
