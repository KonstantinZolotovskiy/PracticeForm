package test;

import org.junit.jupiter.api.Test;
import utils.DateUtil;

public class PracticeFormTests extends TestBase {

    @Test
    public void practiceFormTest() {
        practiceFormPage
                .openPracticeFormPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setGender(data.gender)
                .setMobileNumber(data.mobileNumber)
                .setBirthDateInput(data.birthDate)
                .setSubject(data.subject)
                .setHobbies(data.hobby)
                .setPicture(data.filePath)
                .setAddress(data.address)
                .setState(data.state)
                .setCity(data.city)
                .clickSubmitButton()
                .verifyModal()
                .verifyModalResults("Student Name", data.firstName + " " + data.lastName)
                .verifyModalResults("Student Email", data.email)
                .verifyModalResults("Gender", data.gender)
                .verifyModalResults("Mobile", data.mobileNumber)
                .verifyModalResults("Date of Birth", new DateUtil().getFormattedDateForCheck(data.birthDate))
                .verifyModalResults("Subjects", data.subject)
                .verifyModalResults("Hobbies", data.hobby)
                .verifyModalResults("Picture", data.fileName)
                .verifyModalResults("Address", data.address)
                .verifyModalResults("State and City", data.state + " " + data.city);
    }
}
