package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultModal = new RegistrationResultsModal();

    SelenideElement
            title = $(".practice-form-wrapper h5"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            mobileNumberInput = $("#userNumber"),
            birthDateInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsContainer input"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit");

    ElementsCollection
            genderInput = $$(".custom-radio");

    public PracticeFormPage openPracticeFormPage() {
        open("/automation-practice-form");
        title.shouldHave(text("Student Registration form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public PracticeFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public PracticeFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public PracticeFormPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public PracticeFormPage setGender(String gender) {
        genderInput.findBy(text(gender)).click();
        return this;
    }

    public PracticeFormPage setMobileNumber(String mobileNumber) {
        mobileNumberInput.setValue(mobileNumber);
        return this;
    }

    public PracticeFormPage setBirthDate(String day, String month, String year) {
        birthDateInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public PracticeFormPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public PracticeFormPage setHobbies(String hobby) {
        hobbiesInput.$(byText(hobby)).click();
        return this;
    }

    public PracticeFormPage setPicture(String filePath) {
        uploadPictureInput.uploadFromClasspath(filePath);
        return this;
    }

    public PracticeFormPage setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public PracticeFormPage setState(String state) {
        stateInput.click();
        stateInput.$(byText(state)).click();
        return this;
    }

    public PracticeFormPage setCity(String city) {
        cityInput.click();
        cityInput.$(byText(city)).click();
        return this;
    }

    public PracticeFormPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public PracticeFormPage verifyModal() {
        registrationResultModal.verifyModalAppears();
        return this;
    }

    public PracticeFormPage verifyModalResults(String key, String value) {
        registrationResultModal.verifyResult(key, value);
        return this;
    }
}
