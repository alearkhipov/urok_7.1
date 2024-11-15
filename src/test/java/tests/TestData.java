package tests;

import com.github.javafaker.Faker;
import java.util.*;

import static utils.RandomUtils.getRandomCityByState;
public class TestData {
    Faker faker = new Faker(new Locale("en-GB"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userGender = faker.options().option("Male", "Female", "Other");
    String userNumber = faker.phoneNumber().subscriberNumber(10);
    String userErrorNumber = faker.phoneNumber().subscriberNumber(9);
    String userBirthDay = String.valueOf(faker.number().numberBetween(1, 30));
    String userBirthMonth = setRandomValue("February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    String userBirthYear = String.valueOf(faker.number().numberBetween(1990, 2010));
    String subjects = faker.options().option( "Arts", "Developer", "Chemistry", "Computer Science", "Manager", "Driver", "Doctor", "Firefighter", "Teacher", "Postman");
    String hobbies = faker.options().option("Sports", "Reading", "Music");
    String picturePath = "1.jpg";
    String address = faker.address().streetAddress();
    String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    String city = getRandomCityByState(state);

    public String setRandomValue (String ... strings){
        ArrayList<String> values = new ArrayList<>();
        Collections.addAll(values,strings);
        String item = values.get(faker.number().numberBetween(0, values.size()-1));
        return item;
    }

}
