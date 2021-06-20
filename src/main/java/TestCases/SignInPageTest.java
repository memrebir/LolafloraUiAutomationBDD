package TestCases;

import PageObjects.HomePageObjects;
import PageObjects.SignInPageObjects;
import PageObjects.SignUpPageObjects;
import Utilies.DriverWait;
import Utilies.Switch;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SignInPageTest {

    private final WebDriver driver;

    public SignInPageTest() {
        this.driver = DriverSetup.driver;
    }

    @When("Navigate to lolaflora.com signInPage URL")
    public void navigateToHomePage(){
        driver.get(SignInPageObjects.signInPageUrl);
    }

    @And("I'm filling registered e-mail address")
    public void iFillingRegisteredEmailAddress(){
        driver.findElement(SignInPageObjects.eMail).sendKeys(SignInPageObjects.correctUsername);
    }

    @And("I'm filling unregistered e-mail address")
    public void iFillingUnRegisteredEmailAddress(){
        driver.findElement(SignInPageObjects.eMail).sendKeys(SignInPageObjects.incorrectUsername);
    }

    @And("I enter a correct password in the password field")
    public void iEnterACorrectPasswordInThePasswordField(){
        driver.findElement(SignInPageObjects.password).sendKeys(SignInPageObjects.correctPassword);
    }

    @And("I enter a incorrect password in the password field")
    public void iEnterAInCorrectPasswordInThePasswordField(){
        driver.findElement(SignInPageObjects.password).sendKeys(SignInPageObjects.incorrectPassword);
    }

    @And("I click sign in button")
    public void iClickSignInButton(){
        driver.findElement(SignInPageObjects.btnSignIn).click();
    }

    @And("I click forgot password button")
    public void iClickForgotPasswordButton(){
        driver.findElement(SignInPageObjects.btnForgotPassword).click();
    }

    @And("I click sign in with facebook button")
    public void iClickSignInWithFacebookButton(){
        driver.findElement(SignInPageObjects.btnSignInWithFacebook).click();
    }

    @And("I click sign up button")
    public void iClickSignUpButton(){
        driver.findElement(SignInPageObjects.btnSignUp).click();
    }

    @And("I fill forgot password email address")
    public void iFillForgotPasswordEmailAddress(){
        driver.findElement(SignInPageObjects.textForgotPassword).sendKeys("testemre@emre.com");
    }

    @And("I click forgot password send button")
    public void iClickForgotPasswordSendButton(){
        driver.findElement(SignInPageObjects.btnForgetPswSend).click();
    }

    @Then("Is forgot password send process success icon enabled")
    public void isForgotPasswordSendProcessSuccessIconEnabled(){
        Assert.assertTrue(driver.findElement(SignInPageObjects.forgetSuccessIcon).isEnabled());
    }

    @Then("Is Login successful")
    public void isLoginSuccessful(){

        DriverWait.driverWaitExpectedConditions(driver,HomePageObjects.userMenuTitleClassObjects);

        List<WebElement> userMenuTitleElements = driver.findElements(HomePageObjects.userMenuTitleClassObjects);
        boolean isLoginSuccess = false;

        for(int i = 0; i < userMenuTitleElements.size(); i++ ){

            if(userMenuTitleElements.get(i).getText().equals(HomePageObjects.myAccountObjectText)){

                isLoginSuccess = true;

            }
        }

        Assert.assertTrue(isLoginSuccess);

    }

    @Then("Is Login Unsuccessful")
    public void isLoginUnsuccessful(){
        DriverWait.driverWaitExpectedConditions(driver, SignInPageObjects.alertModal);
        Assert.assertEquals(driver.findElement(SignInPageObjects.alertModal).getText(), SignInPageObjects.incorrectMessage);
    }

    @Then("Is there required field warning text for required fields")
    public void isThereRequiredFieldsText(){
        Assert.assertEquals(driver.findElement(SignInPageObjects.requiredFieldEmail).getText(), SignInPageObjects.fieldEmptyMessage);
        Assert.assertEquals(driver.findElement(SignInPageObjects.requiredFieldPassword).getText(), SignInPageObjects.fieldEmptyMessage);
    }

    @Then("Is the sign up page loaded?")
    public void isTheSignUpPageLoaded(){
        DriverWait.driverWaitExpectedConditions(driver,SignUpPageObjects.registerTextElement);
        Assert.assertEquals(driver.findElement(SignUpPageObjects.registerTextElement).getText(), SignUpPageObjects.registerText);
    }

    @Then("Is the sign in with facebook page loaded?")
    public void isTheSignInWithFacebookPageLoaded(){
        Switch.SwitchWindow(driver);
        Assert.assertEquals(driver.getTitle(), SignInPageObjects.facebookWindowTitle);
    }

}
