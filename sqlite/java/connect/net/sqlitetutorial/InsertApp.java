package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertApp {

   
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

   
    public void insert(String name,String actor,String actress,String director, String yop ) {
        String sql = "INSERT INTO Movies (Name, Actor, Actress, Director, YearOfRelease) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, actor);
            pstmt.setString(3, actress);
            pstmt.setString(4, director);
            pstmt.setString(5, yop );
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        InsertApp app = new InsertApp();
        // insert three new rows
        app.insert("Matrix", "Keanu Reves" , "Monica" ,"Wachowski" ,"31-03-1999" );
       app.insert("Avengers", "Robert" , "Natasha" ,"Russo" ,"27-04-2012" );
       app.insert("Justice League", "Heanry" , "Gal" ,"Snyder" ,"16-11-2017" );
    }

}