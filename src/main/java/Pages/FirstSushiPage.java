package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FirstSushiPage {
    public ElementsCollection sushiCol = $$(By.xpath("//div[@class='special-offer']"));
    public SelenideElement shareButton = $(By.xpath("//span[text()='გაზიარება']"));

    public SelenideElement faceBookValidate = $(By.xpath("//div[@id='header_container']/div/h2"));
}
