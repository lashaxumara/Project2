import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class Config {
    SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public void specialSetup() {
        softAssert = new SoftAssert();
        Configuration.reportsFolder = "src/main/resources/ScreenShots";
        Configuration.screenshots = true;
        Configuration.savePageSource = false;
        Configuration.timeout = 10000;
        open("https://www.swoop.ge/");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterMethod(alwaysRun = true)
    public void shutDownBrowser() {
        closeWebDriver();
        SelenideLogger.removeListener("AllureSelenide");
    }
}
