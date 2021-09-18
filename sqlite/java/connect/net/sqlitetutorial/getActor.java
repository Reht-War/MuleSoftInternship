package net.sqlitetutorial;
import java.sql.DriverManager; 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class getActor {

    
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

    
   
       public void GA(String actor){
               String sql = "SELECT Name,Actor,Actress,Director,YearOfRelease  "
                          + "FROM Movies WHERE Actor = ?";
        
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
            // set the value
            pstmt.setString(1,actor);
            //
            ResultSet rs  = pstmt.executeQuery();
            
            // loop through the result set
            while (rs.next()) {
                System.out.println( rs.getString("Name")  +  "\t" + 
                                   rs.getString("Actor") + "\t" +
		                           rs.getString("Actress") + "\t" +
		                        rs.getString("Director") + "\t" +
                                rs.getString("YearOfRelease"));;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    

   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        getActor app = new getActor();

        app.GA("Robert");
    }

}