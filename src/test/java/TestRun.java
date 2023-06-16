import Data.db.ConnectionToSQL;
import Steps.*;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Data.Constants.exceptedErrorText;
import static Data.Constants.facebook;
import static Data.db.SQLStatements.createUser;
import static Data.db.SQLStatements.executeSQLQuery;
import static com.codeborne.selenide.Selenide.screenshot;

@Epic("Working on Swoop.ge,Checking 'კვება'and 'დასვენება',Checking registration Form")
@Feature("Feature - Searching for menu buttons and validating if error poped or not")
public class TestRun extends Config{
    HeaderStep headerStep = new HeaderStep();
    SushiStep sushiStep = new SushiStep();
    FirstSushiStep firstSushiStep = new FirstSushiStep();
    RestStep restStep = new RestStep();
    RegistrationStep registrationStep = new RegistrationStep();

    @Test(description = "TestNG - Navigating To Swoop.ge,Picking 'დასვენება' and comparing prices", groups = "Regression1")
    @Story("Story - Checking 'დასვენება' on Swoop.ge")
    @Description("Allure - Navigating To Swoop.ge,Picking 'დასვენება' and checking Prices")
    @Severity(SeverityLevel.NORMAL)
    public void dasvenebaRun() {
        screenshot("'დასვენება' Test");
        headerStep
                .enterToDasveneba();
        restStep
                .setPriceMin()
                .setPriceMax()
                .searchClick()
                .validateSearchPrices();
    }


    @Test(description = "TestNG - Navigating To Swoop.ge,Picking 'კვება' and then 'სუში' and checking add to wishlist", groups = "Regression1")
    @Story("Story - checking food and add to wishlist on Swoop.ge")
    @Description("Allure - Navigating To Swoop.ge,Picking Sushi and checking add wishlist")
    @Severity(SeverityLevel.NORMAL)
    public void firstSushiMethod() {
        screenshot("First Sushi Method");
        headerStep
                .categoriesElement()
                .categoriesList()
                .categoriesSushiList();
        sushiStep.addWishList();
        softAssert.assertTrue(sushiStep.isLoginDisplayed());
        sushiStep.closeButton();
        softAssert.assertTrue(sushiStep.checkStock());
        softAssert.assertAll();
    }

    @Test(description = "TestNG - Navigating To Swoop.ge,picking food from categories and comparing two prices", groups = "Regression2")
    @Story("Story - checking decreasment of prices on Swoop.ge")
    @Description("Allure - Navigating To Swoop.ge,chosing Sushi from categories menu and comparing first and second prices")
    @Severity(SeverityLevel.NORMAL)
    public void secondSushiMethod() {
        screenshot("Second Sushi Method");
        headerStep
                .categoriesElement()
                .categoriesList()
                .categoriesSushiList();
        sushiStep
                .sortClick()
                .sortPick();
                softAssert.assertTrue(sushiStep.priceMatching());
                softAssert.assertAll();
    }

    @Test(description = "TestNG - Navigating To Swoop.ge,Navigating to Sushi,picking first sushi from list and sharing", groups = "Regression2")
    @Story("Story - Checking that share button on Sushi is orking on Swoop.ge")
    @Description("Allure - Navigating To Swoop.ge,chosing Sushi from categories menu and testing Share button")
    @Severity(SeverityLevel.NORMAL)
    public void thirdSushiMethod() {
        screenshot("Third Sushi Method");
        headerStep
                .categoriesElement()
                .categoriesList()
                .categoriesSushiList();
        firstSushiStep
                .pickFirstSushi()
                .shareButtonClick()
                .handleSecondWindow();
        softAssert.assertEquals(firstSushiStep.validateFacebookWindow(), facebook);

    }

    @Test(description = "testNg - Navigating to swoop.ge, clicking on login and choosing registration, filling fields", groups = "Regression2")
    @Story("Story - Checking registration form and error message")
    @Description("Allure - Navigating To Swoop.ge, clicking on Login button and filling fields")
    @Severity(SeverityLevel.NORMAL)
    public void dbTest() {
        createUser();
        try (Connection connectServ = ConnectionToSQL.serverConnection()) {
            ResultSet result = executeSQLQuery(connectServ);
            if (result.next()) {
                String firstName = result.getString("firstName");
                String lastName = result.getString("lastName");
                String phoneNumber = result.getString("phone");
                String email = result.getString("email");
                String dateBirth = result.getString("dateOfBirth");
                String password = result.getString("password");

                registrationStep
                        .loginButton()
                        .registrationButton()
                        .individualPersonButton()
                        .firstName(firstName)
                        .lastName(lastName)
                        .email(email)
                        .phoneNumber(phoneNumber)
                        .dateBirth(dateBirth)
                        .password(password)
                        .confirmPassword(password)
                        .confirmRegistration();

                softAssert.assertEquals(exceptedErrorText, registrationStep.errorMessage());
                softAssert.assertAll();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Assert.fail();
        }
    }

}
