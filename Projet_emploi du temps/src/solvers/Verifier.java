package solvers; 


import java.util.*;
import constraints.Activity;
import constraints.Constraint;

public class Verifier{
    public Set<Constraint> sConstraint; 
    
    public Verifier(Set<Constraint> sConstraint) {
        this.sConstraint = sConstraint;
    }
    public Set<Constraint> unsatisfied(Map<Activity, Integer> map) {
        Set<Constraint> newconstraints = new HashSet<Constraint>();
        for (Constraint constraint : sConstraint){
            if (constraint.isSatisfied(map)==false){
                newconstraints.add(constraint);
            }
        }
        return newconstraints;
    }
}
