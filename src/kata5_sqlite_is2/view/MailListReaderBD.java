package kata5_sqlite_is2.view;

import kata5_sqlite_is2.model.Mail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MailListReaderBD {

    public static List<Mail> read() throws SQLException, ClassNotFoundException{
        List<Mail> emailList = new ArrayList<Mail>();
        Class.forName("org.sqlite.JDBC");
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:data/us500.db")){
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT email FROM people");
            while(result.next()){
                emailList.add(new Mail(result.getString("email")));
            }
        }
        return emailList;
    }
    
}
