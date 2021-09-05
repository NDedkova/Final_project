package pages;

import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import utils.Property;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private static final Logger logger = Logger.getLogger(LoginPage.class);

    private static final SelenideElement loginField = $(By.id("txtUsername"));
    private static final SelenideElement passwordField = $(By.id("txtPassword"));
    private static final SelenideElement loginButton = $(By.id("btnLogin"));

    public void loginPageOpen() {
        open("https://opensource-demo.orangehrmlive.com/");
    }

    public void login() {

        try {
            String login = Property.getProperty("user_login");
            String password = Property.getProperty("user_password");
            loginField.sendKeys(login);
            passwordField.sendKeys(password);
        } catch (IOException e) {
            e.printStackTrace();
        }
        loginButton.click();
    }

    public void logInToAccount() {
        logger.info("----   Test start  ----");
        loginPageOpen();
        login();
    }
}
