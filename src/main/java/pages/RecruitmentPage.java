package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import utils.WaitUtils;

public class RecruitmentPage {

    WebDriver driver;
    WaitUtils wait;

    public RecruitmentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }
    private By recruitmentMenu = By.xpath("//span[text()='Recruitment']");

    public void clickRecruitment() {
        wait.waitForElementClickable(recruitmentMenu).click();
    }

    private By recruitmentPageHeading = By.xpath("//h6[text()='Recruitment']");

    public boolean isRecruitmentPageDisplayed() {
        return wait.waitForElementVisible(recruitmentPageHeading).isDisplayed();
    }
    private By candidateNameInput =
            By.xpath("//label[text()='Candidate Name']/following::input[1]");

    private By searchButton =
            By.xpath("//button[normalize-space()='Search']");

    private By candidateDropdownOption(String candidateName) {
        return By.xpath(
                "//div[contains(@class,'oxd-autocomplete-option')]//*[contains(normalize-space(),'"
                        + candidateName + "')]"
        );
    }

    public void searchCandidate(String candidateName) {
        wait.waitForElementVisible(candidateNameInput)
                .sendKeys(candidateName);
        wait.waitForElementVisible(
                candidateDropdownOption(candidateName)
        ).click();
        wait.waitForElementClickable(searchButton).click();
    }

    private By candidateTable =
            By.xpath("//div[contains(@class,'oxd-table-body')]");

    public boolean isCandidateDisplayed() {
        return wait.waitForElementVisible(candidateTable).isDisplayed();
    }

    private By addButton = By.xpath("//button[normalize-space()='Add']");

    public void clickAddCandidate() {
        wait.waitForElementClickable(addButton).click();
    }

    private By firstNameInput = By.xpath("//input[@placeholder='First Name']");

    private By middleNameInput = By.xpath("//input[@placeholder='Middle Name']");

    private By lastNameInput = By.xpath("//input[@placeholder='Last Name']");

    public void enterCandidateDetails(String firstName, String middleName, String lastName) {
        wait.waitForElementVisible(firstNameInput).sendKeys(firstName);
        wait.waitForElementVisible(middleNameInput).sendKeys(middleName);
        wait.waitForElementVisible(lastNameInput).sendKeys(lastName);
    }

    private By emailInput = By.xpath("//label[text()='Email']/following::input[1]");

    public void enterEmail(String email) {
        wait.waitForElementVisible(emailInput).sendKeys(email);
    }

    private By vacancyDropdown = By.xpath("//label[text()='Vacancy']/following::div[contains(@class,'oxd-select-text-input')][1]");

    public void selectVacancy(String vacancy) {
        wait.waitForElementClickable(vacancyDropdown).click();
        By vacancyOption = By.xpath(
                "//div[contains(@class,'oxd-select-dropdown')]//*[normalize-space()='"
                        + vacancy + "']"
        );
        wait.waitForElementVisible(vacancyOption).click();
    }
    private By saveButton = By.xpath("//button[normalize-space()='Save']");

    public void saveCandidate() {
        wait.waitForElementClickable(saveButton).click();
    }

    private By candidateProfileHeading = By.xpath("//h6[normalize-space()='Candidate Profile']");

    public boolean isCandidateAdded() {
        return wait.waitForElementVisible(candidateProfileHeading)
                .isDisplayed();
    }

    private By candidateViewIcon =
            By.xpath("//i[contains(@class,'bi-eye-fill')]");

    public void clickCandidateView() {
        wait.waitForElementClickable(candidateViewIcon).click();
    }

    private By shortlistButton =
            By.xpath("//button[normalize-space()='Shortlist']");

    public void clickShortlist() {
        wait.waitForElementClickable(shortlistButton).click();
    }

    private By shortlistSaveButton =
            By.xpath("//h6[normalize-space()='Shortlist Candidate']/following::button[normalize-space()='Save']");

    public void saveShortlist() {
        wait.waitForElementClickable(shortlistSaveButton).click();
    }
    private By scheduleInterviewButton =
            By.xpath("//button[contains(normalize-space(),'Schedule Interview')]");

    public void clickScheduleInterview() {
        wait.waitForElementClickable(scheduleInterviewButton).click();
    }

    private By interviewTitleInput =
            By.xpath("//label[normalize-space()='Interview Title']/following::input[1]");

    public void enterInterviewTitle(String title) {
        wait.waitForElementVisible(interviewTitleInput).sendKeys(title);
    }

    private By interviewerInput =
            By.xpath("//label[normalize-space()='Interviewer']/following::input[@placeholder='Type for hints...'][1]");

    public void enterInterviewer(String interviewer) {
        wait.waitForElementVisible(interviewerInput).sendKeys(interviewer);
    }

    private By interviewDateInput =
            By.xpath("//label[normalize-space()='Date']/following::input[@placeholder='yyyy-dd-mm'][1]");

    public void enterInterviewDate(String date) {
        wait.waitForElementVisible(interviewDateInput).sendKeys(date);
    }

    private By interviewTimeInput =
            By.xpath("//label[normalize-space()='Time']/following::input[@placeholder='hh:mm'][1]");

    public void enterInterviewTime(String time) {
        wait.waitForElementVisible(interviewTimeInput).sendKeys(time);
    }

    private By interviewNotesInput =
            By.xpath("//label[normalize-space()='Notes']/following::textarea[1]");

    public void enterInterviewNotes(String notes) {
        wait.waitForElementVisible(interviewNotesInput).sendKeys(notes);
    }

    private By interviewSaveButton =
            By.xpath("//button[normalize-space()='Save']");

    public void saveInterview() {
        wait.waitForElementClickable(interviewSaveButton).click();
    }

    private By interviewerOption(String interviewer) {
        return By.xpath(
                "//div[contains(@class,'oxd-autocomplete-option')]//*[contains(normalize-space(),'"
                        + interviewer + "')]");
    }
    public void selectInterviewer(String interviewer) {
        wait.waitForElementVisible(interviewerInput).sendKeys(interviewer);
        wait.waitForElementVisible(interviewerOption(interviewer)).click();
    }

    private By markInterviewPassedButton =
            By.xpath("//button[normalize-space()='Mark Interview Passed']");

    public void clickMarkInterviewPassed() {
        wait.waitForElementClickable(markInterviewPassedButton).click();
    }

    private By interviewPassedNotes =
            By.xpath("//label[normalize-space()='Notes']/following::textarea[1]");

    public void enterInterviewPassedNotes(String notes) {
        wait.waitForElementVisible(interviewPassedNotes).sendKeys(notes);
    }

    private By interviewPassedSaveButton =
            By.xpath("//h6[normalize-space()='Mark Interview Passed']/following::button[normalize-space()='Save']");

    public void saveInterviewPassed() {
        wait.waitForElementClickable(interviewPassedSaveButton).click();
    }
}