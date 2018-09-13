package database;

import java.sql.*;

import food.Food;

public class SQLiteInsertFood {

	public static int uniqueID = 1;
	
	public static void insertFood(Food food) {
		Connection c = SQLiteAccess.buildConnection("food.db");
		Statement stmt = null;
		try {
			stmt = c.createStatement();
			String command = "INSERT INTO FOOD (ID,NAME,ENERGY,PROTEIN,FAT,SFA,CARB,SUGAR,SODIUM,COST) " + 
						 "VALUES (" + uniqueID + ", '" + food.getName() + "', " + food.getEnergy() + ", " + food.getProtein() + ", " + food.getFat() + ", " + food.getSfa() + ", " + food.getCarb() + ", " + food.getSugar() + ", " + food.getSodium() + ", " + food.getCost() + " );";
			uniqueID++;
			stmt.executeUpdate(command);
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Food "+food.getName()+"Inserted successfully");
	}
}
