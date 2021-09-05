package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LogoutPage {

    public SelenideElement menuButton = $(By.xpath("//a[contains (text(), 'Welcome')]"));
    public SelenideElement logout = $(By.xpath("//a[text() ='Logout']"));

    @Step("Log out")
    public void logoutOrange() {
        menuButton.click();
        logout.click();
    }
}
