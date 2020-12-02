package kata5_sqlite_is2.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kata5_sqlite_is2.model.City;

public class CityListReaderBD {
    public static List<City> read() throws SQLException, ClassNotFoundException{
        List<City> citiesList = new ArrayList<City>();
        Class.forName("org.sqlite.JDBC");
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:data/us500.db")){
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT city,county FROM people WHERE state='CA'");
            while(result.next()){
                citiesList.add(new City(result.getString("city"), result.getString("county")));
            }
        }
        return citiesList;
    }
}
