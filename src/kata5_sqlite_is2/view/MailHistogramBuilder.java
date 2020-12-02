package kata5_sqlite_is2.view;

import kata5_sqlite_is2.model.Mail;
import kata5_sqlite_is2.model.Histogram;
import java.util.List;

public class MailHistogramBuilder {

    public Histogram<String> build(List<Mail> mailList) {
        Histogram<String> histogram = new Histogram();
        mailList.forEach(mail -> {
            if(filtrarDominios(mail.getDomain())){
                histogram.increment(mail.getDomain());
            } else {
                histogram.increment("Others");
            }
        });
        return histogram;
    }
    
    private boolean filtrarDominios(String mail){
        String[] emails = {"yahoo.com", "hotmail.com", "gmail.com", "aol.com", "cox.net"};
        for (String email : emails) {
            if (mail.equals(email)) return true;
        }
        return false;
    }

}
