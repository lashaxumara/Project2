package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HeaderPage {
    public SelenideElement categoriesEl = $("div[class=NewCategories]");

    public ElementsCollection categoriesList = $$(By.xpath("//div[@class='LeftSideCategories']/ul/li"));

    public ElementsCollection categoriesSushiList = $$(By.xpath("//div[@class='mobileSubCategories subCategory-3 openedMenu']/ul/li/a"));

    public ElementsCollection dashBoardMenu = $$(By.xpath("//div[@class='Menus']//li"));
}
