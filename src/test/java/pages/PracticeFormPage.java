package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import utils.DateUtil;

import java.io.File;
import java.util.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

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
            datePicker = $(".react-datepicker__month-container"),
            submitButton = $("#submit"),
            modal = $(".modal-content"),
            table = $(".table-responsive");

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

    public PracticeFormPage setBirthDateInput(Date birthDate) {
        birthDateInput.click();
        birthDateInput.sendKeys(Keys.CONTROL + "a");
        birthDateInput.sendKeys(new DateUtil().getFormattedDate(birthDate));
        birthDateInput.pressEnter();
        datePicker.should(disappear);
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
        uploadPictureInput.uploadFile(new File(filePath));
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
        modal.should(appear);
        return this;
    }

    public PracticeFormPage verifyModalResults(String key, String value) {
        table.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}
