package kata5_sqlite_is2.model;

public class City {
    private final String city;
    private final String country;

    public City(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String city(){
        return city;
    }
    
    public String getCountry() {
        return country;
    }
    
}
