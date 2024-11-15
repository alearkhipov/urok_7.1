package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.components.CalendarComponent;
import pages.components.ResultComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitInput = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultComponent resultComponent = new ResultComponent();

    public RegistrationPage openPage()
    {
        open("/automation-practice-form");
        return this;
    }
    public RegistrationPage setFirstName(String value)
    {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value)
    {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setEmail(String value)
    {
        userEmailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value)
    {
        genderInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setNumber(String value)
    {
        numberInput.setValue(value).scrollTo();
        return this;
    }
    public RegistrationPage setErrorNumber(String value)
    {
        numberInput.setValue(value).scrollTo();
        return this;
    }
    public RegistrationPage setDateOfBirth(String year, String month, String day) {
        dateOfBirthInput.click();
        calendarComponent.setDate(year, month, day);
        return this;
    }

    public RegistrationPage setSubjects(String subject)
    {
        subjectsInput.setValue(subject).sendKeys(Keys.ENTER);
        ;
        return this;
    }
    public RegistrationPage setHobbies(String value)
    {
        hobbiesInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setPicturePath(String path)
    {
        uploadPictureInput.uploadFromClasspath(path);
        return this;
    }
    public RegistrationPage setAddress(String value)
    {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState(String state)
    {
        stateInput.click();
        stateInput.$(byText(state)).click();
        return this;
    }

    public RegistrationPage setCity(String city)
    {
        cityInput.click();
        cityInput.$(byText(city)).click();
        return this;
    }

    public RegistrationPage clickSubmit()
    {
        submitInput.click();
        return this;
    }

    public RegistrationPage tableResults(String key, String value)
    {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public RegistrationPage tableResultsIsNotVisible()
    {
        resultComponent.tableResultsIsNotVisible();
        return this;
    }
}
