package utils;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class RandomUtils {
    static Faker faker = new Faker(new Locale("en-GB"));

    public static String getRandomCityByState(String state) {
        Map<String, String[]> citiesByState = new HashMap<>();
        citiesByState.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        citiesByState.put("Uttar Pradesh", new String[]{"Lucknow", "Agra", "Merrut"});
        citiesByState.put("Haryana", new String[]{"Karnal", "Panipat"});
        citiesByState.put("Rajasthan", new String[]{"Jaiselmer", "Jaipur"});

        var citiesForThisState = citiesByState.get(state);
        return faker.options().option(citiesForThisState);
    }
}

