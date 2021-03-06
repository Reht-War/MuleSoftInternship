package net.sqlitetutorial;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SelectApp {

    
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:D://sqlite/db/MuleSoft.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    
   
    public void selectAll(){
        String sql = "SELECT Name,Actor,Actress,Director,YearOfRelease  FROM Movies";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println( rs.getString("Name")  +  "\t" + 
                                   rs.getString("Actor") + "\t" +
		                           rs.getString("Actress") + "\t" +
		                        rs.getString("Director") + "\t" +
                                rs.getString("YearOfRelease"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    

   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SelectApp app = new SelectApp();
        app.selectAll();
    }

}