package database;
import java.util.ArrayList;

import food.*;

public class SQLiteMasterAccessTest {

	public static void main (String[] Args) {
		SQLiteNewDatabase.newDatabase();
		SQLiteNewTable.newTable();
		ArrayList<Food> fList = new ArrayList<Food>();
		Food bigMac = new Food("Big Mac", 2180, 26.9, 28.6, 11.3, 37.4, 6.4, 993, 5.5);
		fList.add(bigMac);
		SQLiteInsertFood.insertFoodList(fList);
		//Basic structure completed, run this code to see inserted food big mac.
		SQLiteFoodSelect.selectAll();
	}
}
