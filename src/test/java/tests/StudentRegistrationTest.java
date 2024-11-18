package tests;

import org.junit.jupiter.api.Test;

public class StudentRegistrationTest extends TestBase {

    @Test
    void studentRegistrationTest() {

        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail (testData.userEmail)
                .setGender(testData.userGender)
                .setNumber(testData.userNumber)
                .setDateOfBirth(testData.userBirthYear, testData.userBirthMonth, testData.userBirthDay)
                .setSubjects(testData.subjects)
                .setHobbies(testData.hobbies)
                .setPicturePath(testData.picturePath)
                .setAddress(testData.address)
                .setState(testData.state)
                .setCity(testData.city)
                .clickSubmit();

        registrationPage.tableResults("Student Name", testData.firstName + " " + testData.lastName)
                .tableResults("Student Email", testData.userEmail)
                .tableResults("Gender", testData.userGender)
                .tableResults("Mobile", testData.userNumber)
                .tableResults("Date of Birth", testData.userBirthDay + " " + testData.userBirthMonth + ","
                        + testData.userBirthYear)
                .tableResults("Subjects", testData.subjects)
                .tableResults("Hobbies", testData.hobbies)
                .tableResults("Picture", testData.picturePath)
                .tableResults("Address", testData.address)
                .tableResults("State and City", testData.state + " " + testData.city);

    }

    @Test
    void studentRegistrationFormMinimumDateTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail (testData.userEmail)
                .setGender(testData.userGender)
                .setNumber(testData.userNumber)
                .setDateOfBirth(testData.userBirthYear, testData.userBirthMonth, testData.userBirthDay)
                .clickSubmit();

        registrationPage.tableResults("Student Name", testData.firstName + " " + testData.lastName)
                .tableResults("Student Email", testData.userEmail)
                .tableResults("Gender", testData.userGender)
                .tableResults("Mobile", testData.userNumber)
                .tableResults("Date of Birth", testData.userBirthDay + " " + testData.userBirthMonth + ","
                        + testData.userBirthYear);
    }

    @Test
    void studentRegistrationFormIncorrectEmailTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail (testData.userEmail)
                .setGender(testData.userGender)
                .setErrorNumber(testData.userErrorNumber)
                .setDateOfBirth(testData.userBirthYear, testData.userBirthMonth, testData.userBirthDay)
                .clickSubmit();

        registrationPage.tableResultsIsNotVisible();
    }
}