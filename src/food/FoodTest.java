package food;

import database.SQLiteFoodSelect;

public class FoodTest {
	public static void main(String[] args) {
		Food test1 = new Food("Test1", 107.6, 21.9, 10.8, 9, 0.7, 3, 5, 10);
		test1.insertFood();
		Food rt1 = SQLiteFoodSelect.getFoodByName("Test1");
		System.out.println(rt1.toString());
		rt1.deleteFood();
		SQLiteFoodSelect.selectAll();
		
	}
}
