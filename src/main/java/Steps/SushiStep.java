package Steps;

import Pages.SushiPage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static Data.Constants.maxPercentage;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class SushiStep extends SushiPage {
    @Step("Click on 'აირჩიე სორტირების ტიპი'")
    public SushiStep sortClick() {
        sortEl.click();
        return this;
    }

    @Step("Click on 'ფასი კლებადი'")
    public SushiStep sortPick() {
        for (SelenideElement el : sortListSelect) {
            if (el.getText().equalsIgnoreCase("ფასით კლებადი")) {
                el.click();
            }
        }
        return this;
    }

    @Step("Checking that first given product's price is greater then second product's price")
    public boolean priceMatching() {
        int firstPrice = Integer.parseInt(pricesList.get(0).getText().replaceAll("[^0-9]", ""));
        int secondPrice = Integer.parseInt(pricesList.get(1).getText().replaceAll("[^0-9]", ""));
        return firstPrice > secondPrice;
    }
//---------------------------------------------------------------------------
    @Step("Click on first option's Wishlist button")
    public SushiStep addWishList() {
        SelenideElement firstMember = wishList.get(0);
        firstMember.click();

        return this;
    }

    @Step("Validation that registration Form is displayed")
    public boolean isLoginDisplayed() {
        Selenide.Wait().until(driver -> loginWindow.isDisplayed());
        return loginWindow.isDisplayed();
    }

    @Step("Close register Form")
    public SushiStep closeButton() {
        executeJavaScript("arguments[0].click();", closeRegister);
        return this;
    }

    @Step("Check that producs are not fully sold-out")
    public boolean checkStock() {
        String dataWidth = voucherLimit.get(1).getAttribute("data-width");
        double percentage = Double.parseDouble(dataWidth);
        int formattedNumber = (int) Math.round(percentage);
        return formattedNumber < maxPercentage;
    }
}
