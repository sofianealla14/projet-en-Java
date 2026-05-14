package constraints;

public class PrecedenceConstraintWithGap extends PrecedenceConstraint  {  //PrecedenceConstraint fait au TP1 que j'ai déposer dans le package
	
	int delaiMax,delaiMin;
	
	public PrecedenceConstraintWithGap (Activity act1 , Activity act2 , int delaiMin , int delaiMax ) {
		
		super(act1,act2);
		this.delaiMax = delaiMax;
		this.delaiMin = delaiMin;
	}
		
	
	public boolean isSatisfied(int d1,int d2) {
		if (super.isSatisfied (d1 , d2)){
			if (d1+delaiMin+act1.getDuration() <= d2  &&  d2 <= delaiMax+d1+act1.getDuration()) 
			return true;
		}
		return false;
	}
	
	
}


