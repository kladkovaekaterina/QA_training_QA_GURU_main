package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import pages.components.CalendarComponent;
import pages.components.TableResultComponent;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            mobileInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureUpload = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            stateAndCityInput = $("#stateCity-wrapper"),
            submitClick = $("#submit"),
            checkResultPos = $("#example-modal-sizes-title-lg"),
            checkResultNeg = $("[class]");

    CalendarComponent calendarComponent = new CalendarComponent();
    TableResultComponent tableResultComponent = new TableResultComponent();

    // Open form
    public StudentRegistrationFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    // Name
    public StudentRegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public StudentRegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    // Email
    public StudentRegistrationFormPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    // Gender
    public StudentRegistrationFormPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }

    // Mobile
    public StudentRegistrationFormPage setMobile(String value) {
        mobileInput.setValue(value);

        return this;
    }

    // Date of Birth
    public StudentRegistrationFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    // Subjects
    public StudentRegistrationFormPage setSubjects(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    // Hobbies
    public StudentRegistrationFormPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }

    // Picture
    public StudentRegistrationFormPage setPicture(String fileName) {
        pictureUpload.uploadFromClasspath(fileName);

        return this;
    }

    // Current Address
    public StudentRegistrationFormPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    // State and City
    public StudentRegistrationFormPage setState(String value) {
        stateInput.click();
        stateAndCityInput.$(byText(value)).click();

        return this;
    }

    public StudentRegistrationFormPage setCity(String value) {
        cityInput.click();
        stateAndCityInput.$(byText(value)).click();

        return this;
    }

    // Submit
    public StudentRegistrationFormPage submitForm() {
        submitClick.click();

        return this;
    }

    // Check results
    public StudentRegistrationFormPage checkSubmitResultPos(String key, String value) {
        checkResultPos.shouldHave(exactText("Thanks for submitting the form"));
        tableResultComponent.checkResult(key, value);

        return this;
    }

    public StudentRegistrationFormPage checkSubmitResultNeg() {
        checkResultNeg.shouldNotHave((text("Thanks for submitting the form")));

        return this;
    }

}