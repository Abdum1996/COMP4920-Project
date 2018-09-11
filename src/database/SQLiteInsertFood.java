package database;

import java.sql.*;

public class SQLiteInsertFood {

	public SQLiteInsertFood() {
		super();
	}

	public static int uniqueID = 1;
	
	public static void insertFood(String name, double energy, double protein, double fat, double sfa, double carb, double sugar, double sodium, double cost) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:food.db");
			c.setAutoCommit(false);
			System.out.println("Food database opened successfully");
			stmt = c.createStatement();
			String sql = "INSERT INTO FOOD (ID,NAME,ENERGY,PROTEIN,FAT,SFA,CARB,SUGAR,SODIUM,COST) " + 
						 "VALUES (" + uniqueID + ", '" + name + "', " + energy + ", " + protein + ", " + fat + ", " + sfa + ", " + carb + ", " + sugar + ", " + sodium + ", " + cost + " );";
			uniqueID++;
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Food "+name+"Inserted successfully");
	}
}
