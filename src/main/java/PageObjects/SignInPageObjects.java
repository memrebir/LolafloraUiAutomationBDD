package PageObjects;

import org.openqa.selenium.By;

public class SignInPageObjects {

    public static By eMail = By.id("EmailLogin");

    public static By password = By.id("Password");

    public static By btnSignIn = By.className("js-login-button");

    public static By btnForgotPassword = By.className("js-forgot-password");

    public static By textForgotPassword = By.id("Mail");

    public static By btnForgetPswSend = By.className("js-password-recovery-button");

    public static By btnSignUp = By.className("btn-warning");

    public static By btnSignInWithFacebook = By.className("login__social-text");

    public static By alertModal = By.className("modal-body");

    public static By requiredFieldEmail = By.id("EmailLogin-error");

    public static By requiredFieldPassword = By.id("Password-error");

    public static By forgetSuccessIcon = By.className("password-recovery-result__icon");

    public static String signInPageUrl = "https://www.lolaflora.com/login";

    public static String correctUsername = "otomasyonemre@test.com";

    public static String correctPassword = "123456";

    public static String incorrectUsername = "test@test.com";

    public static String incorrectPassword = "123456";

    public static String incorrectMessage = "E-mail address or password is incorrect. Please check your information and try again.";

    public static String fieldEmptyMessage = "Required field.";

    public static String facebookWindowTitle = "Facebook'a Giriş Yap | Facebook";
}
