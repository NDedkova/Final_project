package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RecruitmentPage {

    public SelenideElement recruitmentButton = $(By.id("menu_recruitment_viewRecruitmentModule"));
    public SelenideElement candidatesButton = $(By.id("menu_recruitment_viewCandidates"));
    public SelenideElement addCandidateButton = $(By.id("btnAdd"));
    public SelenideElement firstNameField = $(By.id("addCandidate_firstName"));
    public SelenideElement lastNameField = $(By.id("addCandidate_lastName"));
    public SelenideElement emailField = $(By.id("addCandidate_email"));
    public SelenideElement contactField = $(By.id("addCandidate_contactNo"));
    public SelenideElement jobVacancyField = $(By.id("addCandidate_vacancy"));
    public SelenideElement jobVacancyValue = $(By.xpath("//option[contains (text(), 'Junior Account Assistant')]"));
    public SelenideElement saveCandidateButton = $(By.id("btnSave"));
    public SelenideElement addCandidateResult = $(By.cssSelector("#search-results"));
}
