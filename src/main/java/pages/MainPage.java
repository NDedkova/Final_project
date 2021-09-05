package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends LoginPage {

    public SelenideElement welcomeMessage = $(By.id("welcome"));
}
