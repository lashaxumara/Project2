package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RestPage {

    public  SelenideElement minPriceField = $(By.xpath("//div[@id='sidebar']//input[@id = 'minprice']"));
    public  SelenideElement maxPriceField = $(By.xpath("//div[@id='sidebar']//input[@id = 'maxprice']"));
    public  SelenideElement priceTag= $(By.xpath("//div[@class='price-filter']/h2[text()='ფასი']"));
    public SelenideElement searchButton = $(By.xpath("//div[@id='sidebar']/div/div/div/section/div/div[6]/div[1]"));
    public ElementsCollection priceRange = $$("div.discounted-prices>p:first-child");
    public SelenideElement waitEl = $(By.id("render"));
}
