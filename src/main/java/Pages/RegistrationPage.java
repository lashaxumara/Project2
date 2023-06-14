package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    public SelenideElement loginButton = $(By.xpath("//div[@class='HeaderTools swoop-login']"));

    public SelenideElement registerButton = $("a#ui-id-3");
    public SelenideElement individualPersonButton = $("a#ui-id-1");

    public SelenideElement firstName = $(By.id("pFirstName"));
    public SelenideElement lastName = $(By.id("pLastName"));
    public SelenideElement email = $(By.id("pEmail"));
    public SelenideElement dateBirth = $(By.id("pDateBirth"));
    public SelenideElement mobileNumber = $(By.id("pPhone"));
    public SelenideElement password = $(By.id("pPassword"));
    public SelenideElement confirmPass = $(By.id("pConfirmPassword"));
    public SelenideElement confirmRegistration = $(By.xpath("//input[@type='button']"));
    public SelenideElement errorMessage = $(By.id("physicalInfoMassage"));
}
