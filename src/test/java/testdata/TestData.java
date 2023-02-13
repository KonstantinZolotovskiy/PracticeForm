package testdata;

import com.github.javafaker.Faker;
import enums.Gender;
import enums.Hobbies;
import enums.State;
import enums.Subjects;
import enums.city.Haryana;
import enums.city.NCR;
import enums.city.Rajasthan;
import enums.city.UttarPradesh;
import utils.DateUtil;
import utils.EnumUtil;

public class TestData {
    Faker faker = new Faker();
    DateUtil dateUtil = new DateUtil();

    public String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = EnumUtil.getRandomEnum(Gender.class).getGender(),
            mobileNumber = faker.phoneNumber().subscriberNumber(10),
            subject = EnumUtil.getRandomEnum(Subjects.class).getSubject(),
            hobby = EnumUtil.getRandomEnum(Hobbies.class).getHobbies(),
            filePath = "person.png",
            fileName = "person.png",
            address = faker.address().fullAddress(),
            state = EnumUtil.getRandomEnum(State.class).getState(),
            city = getCity();
    public String[] birthDate = dateUtil.getFormattedDate(faker.date().birthday()).split(" ");

    private String getCity() {
        city = null;

        if (state.equals(State.NCR.getState())) {
            city = EnumUtil.getRandomEnum(NCR.class).getValue();
        }

        if (state.equals(State.UTTAR_PRADESH.getState())) {
            city = EnumUtil.getRandomEnum(UttarPradesh.class).getValue();
        }

        if (state.equals(State.HARYANA.getState())) {
            city = EnumUtil.getRandomEnum(Haryana.class).getValue();
        }

        if (state.equals(State.RAJASTHAN.getState())) {
            city = EnumUtil.getRandomEnum(Rajasthan.class).getValue();
        }

        return city;
    }
}
