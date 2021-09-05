package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AdminPage {

    public SelenideElement adminButton = $(By.id("menu_admin_viewAdminModule"));
    public SelenideElement userManagementButton = $(By.id("menu_admin_UserManagement"));
    public SelenideElement addUserButton = $(By.id("btnAdd"));
    public SelenideElement employeeNameField = $(By.xpath("//input[@class= 'formInputText inputFormatHint ac_input']"));
    public SelenideElement userNameField = $(By.id("systemUser_userName"));
    public SelenideElement newUserPasswordField = $(By.name("systemUser[password]"));
    public SelenideElement confirmPasswordField = $(By.name("systemUser[confirmPassword]"));
    public SelenideElement saveButton = $(By.id("btnSave"));
    public SelenideElement jobButton = $(By.id("menu_admin_Job"));
    public SelenideElement jobTitleButton = $(By.id("menu_admin_viewJobTitleList"));
    public SelenideElement addJobTitleButton = $(By.id("btnAdd"));
    public SelenideElement jobTitleField = $(By.name("jobTitle[jobTitle]"));
    public SelenideElement saveJobTitleButton = $(By.name("btnSave"));
    public SelenideElement deleteJobTitle = $(By.id("btnDelete"));
    public SelenideElement confirmDeletingJobTitle = $(By.id("dialogDeleteBtn"));

    @Step("Get job title selector")
    public SelenideElement getJobTitleSelector(String job) {
        return $(new By.ByXPath("//a[contains (text(),'" + job + "')]/parent::td/parent::tr/td[1]/input"));
    }
}
