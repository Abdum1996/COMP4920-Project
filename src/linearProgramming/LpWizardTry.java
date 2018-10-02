package linearProgramming;

import java.util.ArrayList;
import java.util.HashMap;

import food.*;
import masterAccess.*;

public class LpWizardTry {
	ArrayList<Food> fList;
	HashMap<String, Double> dailyNeed = MasterAccess.getDailyneedvalue();
	String lowest;
	
	public LpWizardTry(ArrayList<Food> fList, String lowest) {
		this.fList = fList;
		this.lowest = lowest;
	}
	
	
	
}
