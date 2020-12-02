package kata5_sqlite_is2;

import java.sql.SQLException;
import java.util.List;
import kata5_sqlite_is2.model.Histogram;
import kata5_sqlite_is2.model.Mail;
import kata5_sqlite_is2.view.HistogramDisplay;
import kata5_sqlite_is2.view.MailHistogramBuilder;
import kata5_sqlite_is2.view.MailListReaderBD;

public class Kata5_sqLite_IS2 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        
        List<Mail> mailList = MailListReaderBD.read();
        
        Histogram<String> histogram = new MailHistogramBuilder().build(mailList);
        
        HistogramDisplay histogramDisplay = new HistogramDisplay(histogram, "Histogram Display");
        histogramDisplay.execute();
    }
    
}
