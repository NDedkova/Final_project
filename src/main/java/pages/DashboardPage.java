package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {

    public SelenideElement dashboardButton = $(By.id("menu_dashboard_index"));
    public ElementsCollection quickLaunchElement = $$(By.xpath("//div[@class='quickLaunge']"));
    public SelenideElement quickLaunchTable = $(By.id("panel_resizable_0_0"));
    public SelenideElement employeeDistributionBySubunitElement = $(By.id("panel_resizable_1_0"));
    public SelenideElement legendElement = $(By.id("panel_resizable_1_1"));
    public SelenideElement pendingLeaveRequestsElement = $(By.id("panel_resizable_1_2"));
}
