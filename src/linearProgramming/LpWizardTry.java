package linearProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import food.*;
import masterAccess.*;
import scpsolver.problems.*;

public class LpWizardTry {
	ArrayList<Food> fList;
	HashMap<String, Double> dailyNeed;
	String lowest;
	ArrayList<String> variables;
	
	public LpWizardTry(ArrayList<Food> fList, String lowest) {
		this.fList = fList;
		this.dailyNeed = MasterAccess.getDailyneedvalue();
		this.lowest = lowest;
		this.variables = new ArrayList<String>(Arrays.asList("energy", "protein", "fat", "sfa", "carb", "sugar", "sodium", "cost"));
	}
	
	public HashMap<String, Integer> getLowestCombo() {
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		LPWizard lpw = new LPWizard();
		lpw.plus(lowest, 1.0);
		lpw.setMinProblem(true);
		for(String variable : variables) {
			if(variable.equals(lowest))
				continue;
			LPWizardConstraint lpwC = lpw.addConstraint(variable, dailyNeed.get(variable), "<=");
			for(Food f : fList) {
				lpwC.plus(f.getName(), f.getByString(variable));
			}
			lpwC.setAllVariablesInteger();
		}
		LPSolution sol = lpw.solve();
		for(Food f : fList) {
			result.put(f.getName(), (int) sol.getInteger(f.getName()));
		}
		return result;
	}
	
}
