package Steps;

import Pages.FirstSushiPage;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

public class FirstSushiStep extends FirstSushiPage {
    @Step("Pick first given result and click on it")
    public FirstSushiStep pickFirstSushi() {
        sushiCol.get(0).click();
        return this;
    }

    @Step("Click on share button after picking first item")
    public FirstSushiStep shareButtonClick() {
        shareButton.click();
        return this;
    }
    @Step("Validating that facebook register appeared")
    public FirstSushiStep validateFacebookWindow() {
        faceBookValidate.getText();
        return this;
    }
    @Step("Switching to second window to get touch on it")
    public FirstSushiStep handleSecondWindow() {
        Selenide.switchTo().window(1);
        return this;
    }
}
