package kata5_sqlite_is2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5_sqLite_IS2 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:data/us500.db")){
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT email FROM people");
            while(result.next()){
                String email = result.getString("email");
                System.out.println(email);
            }
        }
    }
    
}
