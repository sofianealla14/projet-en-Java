package constraints;


public class PrecedenceConstraint extends BinaryConstraint {

	//Activity act1;       ce qu'on a fait avant
	//Activity act2;

	public PrecedenceConstraint(Activity act1, Activity act2) {
		super(act1, act2);
		//this.act1 = act1;
		//this.act2 = act2;
	}

	public Activity getFirst() {
		return this.act1;
	}

	public Activity getSecond() {
		return this.act2;
	}

	public boolean isSatisfied (int d1 , int d2){
		
		if (act1.getDuration() + d1 <= d2){
			return true;
		}
		return false;
	
	}
	
	public String toString() {
		return("contrainte pas respecter :" +  this.getFirst() +" "+ this.getSecond());
	}

	
	

}
