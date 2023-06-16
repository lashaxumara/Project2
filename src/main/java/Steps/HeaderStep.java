package Steps;

import Pages.HeaderPage;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class HeaderStep extends HeaderPage {
    @Step("Click on 'კატეგორიები'")
    public HeaderStep categoriesElement() {
        categoriesEl.click();
        return this;
    }

    @Step("Hover over 'კვება'")
    public HeaderStep categoriesList() {
        for (SelenideElement el : categoriesList) {
            if (el.getText().equalsIgnoreCase("კვება")) {
                actions().moveToElement(el).perform();
                break;
            }
        }
        return this;
    }

    @Step("Click on 'სუში'")
    public HeaderStep categoriesSushiList() {
        for (SelenideElement el : categoriesSushiList) {
            if (el.getText().equalsIgnoreCase("სუში")) {
                executeJavaScript("arguments[0].click();", el);
                break;
            }
        }
        return this;
    }

    @Step("Click on 'დასვენება'")
    public HeaderStep enterToDasveneba() {
        for (SelenideElement members : dashBoardMenu) {
            if (members.getText().equalsIgnoreCase("დასვენება")) {
                members.click();
                break;
            }
        }
        return this;
    }
}
