package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PIMPage {
    public SelenideElement pimButton = $(By.id("menu_pim_viewPimModule"));
    public SelenideElement addEmployeeButton = $(By.id("menu_pim_addEmployee"));
    public SelenideElement addEmployeeFirstNameField = $(By.name("firstName"));
    public SelenideElement addEmployeeLastNameField = $(By.name("lastName"));
    public SelenideElement createLogDetailsButton = $(By.name("chkLogin"));
    public SelenideElement employeeUserNameField = $(By.name("user_name"));
    public SelenideElement employeePasswordField = $(By.name("user_password"));
    public SelenideElement employeeConfirmPasswordField = $(By.name("re_password"));
    public SelenideElement addEmployeeSaveButton = $(By.id("btnSave"));
    public SelenideElement personalDetails = $(By.xpath("//h1[text()='Personal Details']"));

    public SelenideElement employeeListButton = $(By.id("menu_pim_viewEmployeeList"));
    public SelenideElement selectJobTitleField = $(By.name("empsearch[job_title]"));
    public SelenideElement selectJobTitleButton = $(By.xpath("//option[contains (text(), 'Sales')][1]"));
    public SelenideElement newEmployeeNameField = $(By.name("empsearch[employee_name][empName]"));
    public SelenideElement employeeFirstName = $(By.xpath("//a/parent::td/parent::tr/td[3]/a"));
    public SelenideElement employeeLastName = $(By.xpath("//a/parent::td/parent::tr/td[4]/a"));
    public SelenideElement firstNameInPersonalDetails = $(By.id("personal_txtEmpFirstName"));
    public SelenideElement lastNameInPersonalDetails = $(By.id("personal_txtEmpLastName"));

    public SelenideElement employeeNameForDeleteField = $(By.name("empsearch[employee_name][empName]"));
    public SelenideElement searchForDeleteButton = $(By.id("searchBtn"));
    public SelenideElement checkboxEmployeeDelete = $(By.xpath("//a[text()='Valdemar']/parent::td/parent::tr/td[1]/input"));
    public SelenideElement deleteEmployeeButton = $(By.id("btnDelete"));
    public SelenideElement deleteEmployeeMessage = $(By.xpath("//td[text()='No Records Found']"));
    public SelenideElement dialogDeleteEmployeeButton = $(By.id("dialogDeleteBtn"));

    public SelenideElement membershipButton = $(By.xpath("//ul[@id='sidenav']//a[text()='Memberships']"));
    public SelenideElement addMembershipButton = $(By.id("btnAddMembershipDetail"));
    public SelenideElement membershipField = $(By.name("membership[membership]"));
    public SelenideElement project = $(By.xpath("//option[text()='ACCA']"));
    public SelenideElement saveMembershipButton = $(By.id("btnSaveMembership"));
    public SelenideElement rowProjectAcca = $(By.xpath("//a[text()='ACCA']"));

    @Step("Get employee name selector")
    public SelenideElement getEmployeeNameSelector(String name) {
        return $(new By.ByXPath("//a[text()='" + name + "']"));
    }

}
