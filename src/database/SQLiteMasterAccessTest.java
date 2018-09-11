package database;

public class SQLiteMasterAccessTest {

	public static void main (String[] Args) {
		SQLiteNewDatabase.newDatabase();
		SQLiteNewTable.newTable();
		SQLiteInsertFood.insertFood("Big Mac", 2180, 26.9, 28.6, 11.3, 37.4, 6.4, 993, 5.5);
		SQLiteFoodSelect.selectAll();
	}
}
