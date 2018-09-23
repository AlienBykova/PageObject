package pageObjects.facebook;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class FacebookLoginPage extends BasePage {

    private static final String FACEBOOK_LOGIN_URL = "https://www.facebook.com";

    private static final String LOGIN = "bykova.alien@gmail.com";

    private static final String PASSWORD = "alena29071995";

    @FindBy(xpath = "//form[@id= \"login_form\"]//input[@type=\"email\"]")
    private WebElement emailField;

    @FindBy(xpath = "//form[@id= \"login_form\"]//input[@type=\"password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//form[@id= \"login_form\"]//input[@type=\"submit\"]")
    private WebElement loginButton;

    public void openPage() {
        openPage(FACEBOOK_LOGIN_URL);
    }

    public FacebookProfileStartPage login() {
        emailField.sendKeys(LOGIN);
        passwordField.sendKeys(PASSWORD);
        loginButton.submit();
        return new FacebookProfileStartPage();
    }


}
