package kata5_sqlite_is2.model;

public class Mail {
    
    private final String mail;

    public Mail(String mail) {
        this.mail = mail;
    }
    
    public String getDomain(){
        return mail.substring(mail.indexOf("@") + 1);
    }
}
