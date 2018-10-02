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
		this.variables = new ArrayList<String>(Arrays.asList("Energy", "Protein", "Fat", "Sfa", "Carb", "Sugar", "Sodium", "Cost"));
	}
	
	public HashMap<String, Integer> getLowestCombo() {
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		HashMap<String, LPWizardConstraint> lpwCList = new HashMap<String, LPWizardConstraint>();
		LPWizard lpw = new LPWizard();
		lpw.plus(lowest, 1.0);
		for(String variable : variables) {
			if(lowest.equals(variable))
				continue;
			System.out.print("Connstraint " + variable + ": " + dailyNeed.get(variable) + "<= 0 ");
			LPWizardConstraint lpwC = lpw.addConstraint(variable, dailyNeed.get(variable), "<=");
			for(Food f : fList) {
				lpwC = lpwC.plus(f.getName(), f.getByString(variable));
				System.out.print("+ " + f.getName() + " * " + f.getByString(variable) + " ");
			}
			lpwC.setAllVariablesInteger();
			lpwCList.put(variable, lpwC);
			System.out.println();
		}
		
		LPWizardConstraint lpwC = lpw.addConstraint(lowest, 0, "=");
		System.out.print("Connstraint " + lowest + ": 0 = 0 ");
		for(Food f : fList) {
			lpwC = lpwC.plus(f.getName(), f.getByString(lowest));
			System.out.print("+ " + f.getName() + " * " + f.getByString(lowest) + " ");
		}
		lpwC = lpwC.plus(lowest, -1.0);
		System.out.println("- " + lowest + " ");
		lpwCList.put(lowest, lpwC);
		
		for(Food f : fList) {
			LPWizardConstraint lpwCN = lpw.addConstraint("Number"+f.getName(), 0, "<=");
			lpwCN.plus(f.getName(), 1.0);
			lpwCList.put("Number"+f.getName(), lpwCN);
		}
		
		lpw.addConstraints(lpwCList);
		LPSolution sol = lpw.solve();
		for(Food f : fList) {
			result.put(f.getName(), (int) sol.getInteger(f.getName()));
		}
		return result;
	}
	
}
