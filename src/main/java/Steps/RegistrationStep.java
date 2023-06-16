package Steps;

import Pages.RegistrationPage;
import io.qameta.allure.Step;

public class RegistrationStep extends RegistrationPage {
    
    @Step("Click on login button")
    public RegistrationStep loginButton(){
        loginButton.click();
        return this;
    }
    @Step("Click on register button")
    public RegistrationStep registrationButton(){
        registerButton.click();
        return this;
    }
    @Step("Chosing 'ფიზიკური პირი'")
    public RegistrationStep individualPersonButton(){
        individualPersonButton.click();
        return this;
    }
    @Step("Filling firstname field")
    public RegistrationStep firstName(String name){
        firstName.setValue(name);
        return this;
    }
    @Step("Filling lastname field")
    public RegistrationStep lastName(String lName){
        lastName.setValue(lName);
        return this;
    }
    @Step("Filling email field")
    public RegistrationStep email(String mail){
        email.setValue(mail);
        return this;
    }
    @Step("Filling dataOfBirth field")
    public RegistrationStep dateBirth(String dataBirth){
        dateBirth.setValue(dataBirth);
        return this;
    }
    @Step("Filling phonenumber field")
    public RegistrationStep phoneNumber(String phoneNumber){
        mobileNumber.setValue(phoneNumber);
        return this;
    }
    @Step("Filling password field")
    public RegistrationStep password(String pass){
        password.setValue(pass);
        return this;
    }
    @Step("Confirming new password")
    public RegistrationStep confirmPassword(String confirmPassword){
        confirmPass.setValue(confirmPassword);
        return this;
    }
    @Step("Confirming registration")
    public RegistrationStep confirmRegistration(){
        confirmRegistration.click();
        return this;
    }
    @Step("Getting error message to assert")
    public String errorMessage(){
       return errorMessage.getText();
    }
}
