package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class NewTable{

  
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:D://sqlite/db/MuleSoft.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Movies(\n"
                + "	Name text PRIMARY KEY,\n"
	+"	Actor text NOT NULL  ,\n"
	+"	Actress text NOT NULL  ,\n"
	+"	Director text NOT NULL ,\n"
	+"	YearOfRelease text NOT NULL \n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
	System.out.println("A new table has been created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewTable();
    }

}
