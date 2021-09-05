package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LeavePage {

    public SelenideElement leaveButton = $(By.id("menu_leave_viewLeaveModule"));
    public SelenideElement assignLeaveButton = $(By.id("menu_leave_assignLeave"));
    public SelenideElement assignLeaveEmployeeNameField = $(By.name("assignleave[txtEmployee][empName]"));
    public SelenideElement assignLeaveTypeValue = $(By.xpath("//option[contains(text(), 'US - Bereavement')]"));
    public SelenideElement fromAssignLeaveCalendarValue = $(By.name("assignleave[txtFromDate]"));
    public SelenideElement toDateCalendarField = $(By.xpath("//label[contains (text(), 'To Date')]"));
    public SelenideElement toAssignLeaveCalendarValue = $(By.name("assignleave[txtToDate]"));
    public SelenideElement assignLeaveSaveButton = $(By.id("assignBtn"));
    public SelenideElement leaveListButton = $(By.id("menu_leave_viewLeaveList"));
    public SelenideElement allLeaveListButton = $(By.id("leaveList_chkSearchFilter_checkboxgroup_allcheck"));
    public SelenideElement employeeLeaveListButton = $(By.name("leaveList[txtEmployee][empName]"));
    public SelenideElement searchLeaveListButton = $(By.name("btnSearch"));
}
