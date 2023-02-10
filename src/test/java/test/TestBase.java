package test;

import org.junit.jupiter.api.BeforeAll;
import pages.PracticeFormPage;
import testdata.TestData;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browserSize;

public class TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    TestData data = new TestData();

    @BeforeAll
    public static void setUp() {
        browserSize = "1920x1080";
        baseUrl = "https://demoqa.com";
    }
}
