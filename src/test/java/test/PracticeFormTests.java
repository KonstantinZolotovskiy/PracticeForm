package test;

import org.junit.jupiter.api.Test;

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
                .setBirthDate(data.birthDate[0], data.birthDate[1], data.birthDate[2])
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
                .verifyModalResults("Date of Birth", data.birthDate[0] + " " + data.birthDate[1] + "," + data.birthDate[2])
                .verifyModalResults("Subjects", data.subject)
                .verifyModalResults("Hobbies", data.hobby)
                .verifyModalResults("Picture", data.fileName)
                .verifyModalResults("Address", data.address)
                .verifyModalResults("State and City", data.state + " " + data.city);
    }
}
