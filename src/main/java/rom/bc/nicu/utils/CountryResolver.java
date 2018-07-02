package rom.bc.nicu.utils;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class CountryResolver {

    private static final Map<String, String> countries;

    static {
        countries = Arrays.stream(Locale.getISOCountries())
                .map(code -> new Locale("", code))
                .collect(Collectors.toMap(Locale::getDisplayCountry, Locale::getCountry));

    }

    public static Map<String, String> getListOfCountries() {
        return countries;
    }

    public static boolean isValidCountry(String country) {
        return country != null && countries.keySet().contains(country);
    }
}
