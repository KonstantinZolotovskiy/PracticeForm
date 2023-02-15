package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.PracticeFormPage;
import testdata.TestData;

import static com.codeborne.selenide.Configuration.*;

public class TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    TestData data = new TestData();

    @BeforeAll
    public static void setUp() {
        baseUrl = "https://demoqa.com";
        browser = System.getProperty("browser", "chrome");
        browserVersion = System.getProperty("browserVersion", "100.0");
        browserSize = System.getProperty("browserSize", "1920x1080");
        remote = "https://user1:1234@" + System.getProperty("remote", "selenoid.autotests.cloud") + "/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        browserCapabilities = capabilities;
    }

    @BeforeEach
    public void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach()
    public void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}
