package linearProgramming;
import java.util.HashMap;

import database.*;

public class LpTest {
	public static void main (String[] args) {
		LpWizardTry lpwT = new LpWizardTry(SQLiteFoodSelect.selectAllFood(), "Cost");
		HashMap<String, Integer> result = lpwT.getLowestCombo();
		System.out.println(result.toString());
	}
}
