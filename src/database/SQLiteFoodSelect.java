package database;

import java.sql.*;

public class SQLiteFoodSelect {

	public static void selectAll () {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:food.db");
			c.setAutoCommit(false);;
			System.out.println("Food database opened successfully");
			
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM FOOD;");
			while(rs.next()) {
				System.out.println("ID= " + rs.getInt("id"));
				System.out.println("Name= " + rs.getString("name"));
				System.out.println("Energy= " + rs.getFloat("energy"));
				System.out.println("Protein= " + rs.getFloat("protein"));
				System.out.println("Fat= " + rs.getFloat("fat"));
				System.out.println("Saturated Fatty Acids= " + rs.getFloat("sfa"));
				System.out.println("Carbohydrates= " + rs.getFloat("carb"));
				System.out.println("Sugar= " + rs.getFloat("sugar"));
				System.out.println("Sodium= " + rs.getFloat("sodium"));
				System.out.println("Cost= " + rs.getFloat("cost"));
			}
			rs.close();
			stmt.close();
			c.close();		
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Food List print Complete");
	}
}
