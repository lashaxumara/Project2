package Steps;

import Pages.RestPage;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

import static Data.Constants.maximalPrice;
import static Data.Constants.minimalPrice;
import static com.codeborne.selenide.Selenide.*;

public class RestStep extends RestPage {
    SoftAssert softAssert = new SoftAssert();


    @Step("croll to fields and fill with min price")
    public RestStep setPriceMin() {
        executeJavaScript("arguments[0].scrollIntoView();", priceTag);
        minPriceField.setValue(minimalPrice);
        return this;
    }

    @Step("croll to fields and fill with max price")
    public RestStep setPriceMax() {
        maxPriceField.setValue(maximalPrice);
        return this;
    }

    @Step("after filling fields click on search")
    public RestStep searchClick() {
        searchButton.click();
        return this;
    }

    @Step("Get all prices after the search and validate that they are in given min/max price")
    public RestStep validateSearchPrices() {
        int minprc = Integer.parseInt(minimalPrice);
        int maxprc = Integer.parseInt(maximalPrice);
        Wait().until(driver -> waitEl.isDisplayed());
        for (SelenideElement singlePrice : priceRange) {
            int price = Integer.parseInt(singlePrice.getText().replaceAll("[^0-9]", ""));
            softAssert.assertTrue(price >= minprc && price <= maxprc);
        }
        softAssert.assertAll();
        return this;
    }
}



