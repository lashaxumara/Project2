package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SushiPage {
    public SelenideElement sortEl = $(By.id("sort"));
    public ElementsCollection sortListSelect = $$(By.xpath("//div[@class='category-page-select-filter']/select/option"));
    public ElementsCollection pricesList = $$(By.xpath("//div[@class='discounted-prices']/p[@class='deal-voucher-price'][1]"));

    public ElementsCollection wishList = $$(By.cssSelector("div[class=deal-box-wishlist]"));

    public SelenideElement loginWindow = $("div[class=login]");

    public SelenideElement closeRegister = $("div.close-button a");
    public ElementsCollection voucherLimit = $$("div.voucher-limit");


}
