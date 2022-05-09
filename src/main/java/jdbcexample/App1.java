package jdbcexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 */
public final class App1 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");     //Register for drive
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
       String query = "SELECT * from cricketers";
       PreparedStatement ps = con.prepareStatement(query);

       ResultSet rs = ps.executeQuery();

       System.out.println("Names :-");
       while(rs.next()){
           System.out.println(rs.getString("name"));
       }
       con.close();
} catch(SQLException | ClassNotFoundException se){
    System.out.println(se.getMessage());
}

    }
}

