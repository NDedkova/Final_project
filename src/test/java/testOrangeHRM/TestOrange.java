package testOrangeHRM;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Flaky;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.AdminPage;
import pages.DashboardPage;
import pages.LeavePage;
import pages.MainPage;
import pages.PIMPage;
import pages.RecruitmentPage;
import utils.Property;

import java.io.IOException;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Tests for OrangeHRMLive.com")
public class TestOrange extends BeforeAndAfter {

    private static final Logger logger = Logger.getLogger(TestOrange.class);

    private final String employeeName = Property.getProperty("employee_name");
    private final String newUserName = Property.getProperty("new_user_name");
    private final String userPassword = Property.getProperty("new_user_password");

    private final String candidateFirstName = Property.getProperty("candidate-first_name");
    private final String candidateLastName = Property.getProperty("candidate-last_name");
    private final String candidateContact = Property.getProperty("candidate-contact");
    private final String candidateEmail = Property.getProperty("candidate-email");

    private static final MainPage mainPage = new MainPage();
    private static final AdminPage adminPage = new AdminPage();
    private static final RecruitmentPage recruitmentPage = new RecruitmentPage();
    private static final LeavePage leavePage = new LeavePage();
    private static final PIMPage pimPage = new PIMPage();
    private static final DashboardPage dashboardPage = new DashboardPage();

    public TestOrange() throws IOException {
    }

    @Order(1)
    @DisplayName("Log in to account")
    @Test
    public void testLogin() {
        mainPage.welcomeMessage.shouldBe(Condition.visible);

        Assertions.assertTrue(mainPage.welcomeMessage.exists());
    }

    @Order(2)
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Add new candidate")
    @Test
    public void testAddCandidate() {
        logger.info("Navigate to recruitment tab");
        recruitmentPage.recruitmentButton.click();
        recruitmentPage.candidatesButton.click();
        recruitmentPage.addCandidateButton.click();
        recruitmentPage.firstNameField.sendKeys(candidateFirstName);
        recruitmentPage.lastNameField.sendKeys(candidateLastName);
        recruitmentPage.emailField.sendKeys(candidateEmail);
        recruitmentPage.contactField.sendKeys(candidateContact);
        recruitmentPage.jobVacancyField.click();
        recruitmentPage.jobVacancyValue.click();
        recruitmentPage.saveCandidateButton.click();
        recruitmentPage.addCandidateResult.scrollIntoView(true);

        Assertions.assertTrue(recruitmentPage.addCandidateResult.exists());

    }

    @Order(3)
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Add new employee")
    @Test
    public void testAddEmployee() {
        logger.info("Navigate to PIM tab");
        pimPage.pimButton.click();
        pimPage.addEmployeeButton.click();
        pimPage.addEmployeeFirstNameField.sendKeys(candidateFirstName);
        pimPage.addEmployeeLastNameField.sendKeys(candidateLastName);
        pimPage.createLogDetailsButton.setSelected(true);
        pimPage.employeeUserNameField.sendKeys(candidateFirstName);
        pimPage.employeePasswordField.sendKeys(userPassword);
        pimPage.employeeConfirmPasswordField.sendKeys(userPassword);
        pimPage.addEmployeeSaveButton.scrollIntoView(true);
        pimPage.addEmployeeSaveButton.click();

        Assertions.assertEquals("Personal Details", pimPage.personalDetails.getText());
    }

    @Order(4)
    @RepeatedTest(2)
    @Flaky
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Add new user")
    public void testAddUser() {
        logger.info("Attempt to add user");
        logger.info("Navigate to admin tab");
        adminPage.adminButton.click();
        adminPage.userManagementButton.click();
        adminPage.addUserButton.click();
        adminPage.employeeNameField.shouldBe(Condition.visible);
        adminPage.employeeNameField.sendKeys(employeeName);
        adminPage.userNameField.shouldBe(Condition.visible);
        adminPage.userNameField.sendKeys(newUserName);
        adminPage.newUserPasswordField.shouldBe(Condition.visible);
        adminPage.newUserPasswordField.sendKeys(userPassword);
        adminPage.confirmPasswordField.shouldBe(Condition.visible);
        adminPage.confirmPasswordField.sendKeys(userPassword);
        adminPage.saveButton.shouldBe(Condition.visible);
        adminPage.saveButton.click();

        Assertions.assertTrue(pimPage.getEmployeeNameSelector(candidateFirstName).should(Condition.visible).is(Condition.visible));
    }

    @Order(5)
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Create assign Leave")
    @Test
    public void testAssignLeaveCreate() {
        logger.info("Navigate to leave tab");
        leavePage.leaveButton.click();
        leavePage.assignLeaveButton.click();
        leavePage.assignLeaveEmployeeNameField.shouldBe(Condition.visible);
        leavePage.assignLeaveEmployeeNameField.sendKeys(employeeName);
        leavePage.assignLeaveTypeValue.shouldBe(Condition.visible);
        leavePage.assignLeaveTypeValue.click();
        leavePage.fromAssignLeaveCalendarValue.click();
        leavePage.fromAssignLeaveCalendarValue.sendKeys("2021-09-07");
        leavePage.toDateCalendarField.shouldBe(Condition.visible);
        leavePage.toDateCalendarField.click();
        leavePage.toAssignLeaveCalendarValue.clear();
        leavePage.toAssignLeaveCalendarValue.click();
        leavePage.toAssignLeaveCalendarValue.sendKeys("2021-09-07");
        leavePage.assignLeaveSaveButton.scrollIntoView(true).pressEnter();
        leavePage.leaveListButton.shouldBe(Condition.visible);
        leavePage.leaveListButton.click();
        leavePage.allLeaveListButton.shouldBe(Condition.visible);
        leavePage.allLeaveListButton.click();
        leavePage.employeeLeaveListButton.shouldBe(Condition.visible);
        leavePage.employeeLeaveListButton.sendKeys(employeeName);
        leavePage.searchLeaveListButton.shouldBe(Condition.visible);
        leavePage.searchLeaveListButton.click();

        Assertions.assertTrue(pimPage.getEmployeeNameSelector(employeeName).exists());
    }

    @Order(6)
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Manager's profile check")
    @Test
    public void testCheckPersonalDetails() {
        String checkFirstName;
        String checkLastName;

        logger.debug("Navigate to PIM tab");
        pimPage.pimButton.click();
        pimPage.employeeListButton.click();
        pimPage.selectJobTitleField.click();
        pimPage.selectJobTitleButton.click();
        checkFirstName = pimPage.employeeFirstName.getText();
        checkLastName = pimPage.employeeLastName.getText();
        pimPage.employeeFirstName.click();

        Assertions.assertEquals(checkFirstName, pimPage.firstNameInPersonalDetails.getValue());
        Assertions.assertEquals(checkLastName, pimPage.lastNameInPersonalDetails.getValue());
    }

    @Order(7)
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Dashboard check")
    @Test
    public void testCheckDashboardElements() {
        dashboardPage.dashboardButton.click();

        Assertions.assertEquals(6, dashboardPage.quickLaunchElement.size());
        Assertions.assertAll(
                () -> Assertions.assertTrue(dashboardPage.quickLaunchTable.exists()),
                () -> Assertions.assertTrue(dashboardPage.employeeDistributionBySubunitElement.exists()),
                () -> Assertions.assertTrue(dashboardPage.legendElement.exists()),
                () -> Assertions.assertTrue(dashboardPage.pendingLeaveRequestsElement.exists()));
    }

    @Order(8)
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Assign employee to project")
    @Test
    public void testAssignEmployeeToProject() {
        pimPage.pimButton.click();
        pimPage.employeeListButton.click();
        pimPage.employeeNameForDeleteField.sendKeys(candidateFirstName);
        pimPage.searchForDeleteButton.click();
        pimPage.getEmployeeNameSelector(candidateFirstName).shouldBe(Condition.visible);
        pimPage.getEmployeeNameSelector(candidateFirstName).click();
        pimPage.membershipButton.click();
        pimPage.addMembershipButton.click();
        pimPage.membershipField.click();
        pimPage.project.click();
        pimPage.saveMembershipButton.click();

        Assertions.assertTrue(pimPage.rowProjectAcca.exists());

    }

    @Order(9)
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Delete employee")
    @Test
    public void testDeleteEmployee() {
        pimPage.pimButton.click();
        pimPage.employeeNameForDeleteField.sendKeys(candidateFirstName);
        pimPage.searchForDeleteButton.click();
        pimPage.getEmployeeNameSelector(candidateFirstName).shouldBe(Condition.visible);
        pimPage.checkboxEmployeeDelete.setSelected(true);
        pimPage.deleteEmployeeButton.pressEnter();
        pimPage.dialogDeleteEmployeeButton.shouldBe(Condition.visible);
        pimPage.dialogDeleteEmployeeButton.pressEnter();

        Assertions.assertFalse(pimPage.getEmployeeNameSelector(employeeName).exists());
    }

    @Order(10)
    @DisplayName("Job titles add")
    @ParameterizedTest
    @CsvFileSource(resources = "/addJobTitles.csv")
    public void testAddJobTitle(String jobTitle) {
        adminPage.adminButton.click();
        adminPage.jobButton.hover();
        adminPage.jobTitleButton.click();
        adminPage.addJobTitleButton.click();
        adminPage.jobTitleField.sendKeys(jobTitle);
        adminPage.saveJobTitleButton.click();

        Assertions.assertTrue(adminPage.getJobTitleSelector(jobTitle).exists());
    }

    @Order(11)
    @DisplayName("Job titles delete")
    @ParameterizedTest
    @CsvFileSource(resources = "/deleteJobTitles.csv")
    public void testDeleteJobTitle(String jobTitle) {
        adminPage.adminButton.click();
        adminPage.jobButton.hover();
        adminPage.jobTitleButton.click();
        adminPage.getJobTitleSelector(jobTitle).scrollIntoView(true);
        adminPage.getJobTitleSelector(jobTitle).click();
        adminPage.deleteJobTitle.click();
        adminPage.confirmDeletingJobTitle.click();

        Assertions.assertFalse(adminPage.getJobTitleSelector(jobTitle).exists());
    }
}
