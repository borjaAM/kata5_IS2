package kata5_sqlite_is2;

import java.sql.SQLException;
import java.util.List;
import kata5_sqlite_is2.model.City;
import kata5_sqlite_is2.model.Histogram;
import kata5_sqlite_is2.model.Mail;
import kata5_sqlite_is2.view.CityHistogramBuilder;
import kata5_sqlite_is2.view.CityListReaderBD;
import kata5_sqlite_is2.view.HistogramBarChartDisplay;
import kata5_sqlite_is2.view.HistogramPieChartDisplay;
import kata5_sqlite_is2.view.MailHistogramBuilder;
import kata5_sqlite_is2.view.MailListReaderBD;

public class Kata5_sqLite_IS2 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        
        List<Mail> mailList = MailListReaderBD.read();
        
        Histogram<String> histogram = new MailHistogramBuilder().build(mailList);
        
        HistogramBarChartDisplay histogramDisplay = new HistogramBarChartDisplay(histogram, "Histogram Display Emails", "emails domains", "nº emails accounts");
        histogramDisplay.execute();
        
        List<City> citiesList = CityListReaderBD.read();
        Histogram<String> histogram_cities = new CityHistogramBuilder().build(citiesList);
        
        HistogramPieChartDisplay histogramPieDisplay_cities = new HistogramPieChartDisplay(histogram_cities, "Histogram Display workers in State CA");
        histogramPieDisplay_cities.execute();
    }
    
}
