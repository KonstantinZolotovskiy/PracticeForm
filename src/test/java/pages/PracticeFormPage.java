package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    @Step("Открываем страницу регистрации")
    public PracticeFormPage openPracticeFormPage() {
        open("/automation-practice-form");
        title.shouldHave(text("Student Registration form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Указывем First name: \"{firstName}\"")
    public PracticeFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    @Step("Указывем Last name: \"{lastName}\"")
    public PracticeFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Указывем Email: \"{email}\"")
    public PracticeFormPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Указывем Gender: \"{gender}\"")
    public PracticeFormPage setGender(String gender) {
        genderInput.findBy(text(gender)).click();
        return this;
    }

    @Step("Указывем Mobile: \"{mobileNumber}\"")
    public PracticeFormPage setMobileNumber(String mobileNumber) {
        mobileNumberInput.setValue(mobileNumber);
        return this;
    }

    @Step("Указывем Date of Birth: \"{day} {month} {year}\"")
    public PracticeFormPage setBirthDate(String day, String month, String year) {
        birthDateInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Указывем Subjects: \"{subject}\"")
    public PracticeFormPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    @Step("Указывем Hobbies: \"{hobby}\"")
    public PracticeFormPage setHobbies(String hobby) {
        hobbiesInput.$(byText(hobby)).click();
        return this;
    }

    @Step("Загужаем файл \"{filePath}\"")
    public PracticeFormPage setPicture(String filePath) {
        uploadPictureInput.uploadFromClasspath(filePath);
        return this;
    }

    @Step("Указывем Current Address: \"{address}\"")
    public PracticeFormPage setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    @Step("Указывем State: \"{state}\"")
    public PracticeFormPage setState(String state) {
        stateInput.click();
        stateInput.$(byText(state)).click();
        return this;
    }

    @Step("Указывем City: \"{city}\"")
    public PracticeFormPage setCity(String city) {
        cityInput.click();
        cityInput.$(byText(city)).click();
        return this;
    }

    @Step("Нажимаем кнопку \"Submit\"")
    public PracticeFormPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    @Step("Проверям появление подтверждения регистрации")
    public PracticeFormPage verifyModal() {
        registrationResultModal.verifyModalAppears();
        return this;
    }

    @Step("Проверяем, что поле \"{key}\" содержит значение \"{value}\"")
    public PracticeFormPage verifyModalResults(String key, String value) {
        registrationResultModal.verifyResult(key, value);
        return this;
    }
}
