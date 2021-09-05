package testOrangeHRM;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.LogoutPage;
import pages.MainPage;

public class BeforeAndAfter {

    private static final Logger logger = Logger.getLogger(BeforeAndAfter.class);
    private static final MainPage mainPage = new MainPage();
    private static final LogoutPage logoutPage = new LogoutPage();

    @BeforeEach
    public void login() {
        mainPage.logInToAccount();
        logger.info(" ---- Login before test ----  ");
    }

    @AfterEach
    public void logout() {
        logoutPage.logoutOrange();
        logger.info(" ---- Logout after test ----  ");
    }

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(false));
        Configuration.startMaximized = true;
    }

    @AfterAll
    static void tearDown() {
        Selenide.closeWebDriver();
    }
}
