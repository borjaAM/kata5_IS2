package kata5_sqlite_is2.view;

import java.util.List;
import kata5_sqlite_is2.model.Histogram;
import kata5_sqlite_is2.model.City;

public class CityHistogramBuilder {
    public Histogram<String> build(List<City> citiesList) {
        Histogram<String> histogram = new Histogram();
        for (City city : citiesList) {
            histogram.increment(city.getCountry());
        }
        return histogram;
    }
}
