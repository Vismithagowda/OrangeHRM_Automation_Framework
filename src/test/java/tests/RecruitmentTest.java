package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RecruitmentPage;

public class RecruitmentTest extends BaseTest {

    @Test
    public void verifyRecruitmentPage() {

        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);

        loginAsAdmin();

        recruitmentPage.clickRecruitment();

        Assert.assertTrue(
                recruitmentPage.isRecruitmentPageDisplayed(),
                "Recruitment page is not displayed"
        );
    }

    @Test
    public void addCandidate() {

        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);

        loginAsAdmin();

        recruitmentPage.clickRecruitment();
        recruitmentPage.clickAddCandidate();

        recruitmentPage.enterCandidateDetails(
                "Allen",
                "Test",
                "Candidate"
        );

        recruitmentPage.selectVacancy("Junior Account Assistant");
        recruitmentPage.enterEmail("allenadrew@gmail.com");
        recruitmentPage.saveCandidate();

        Assert.assertTrue(
                recruitmentPage.isCandidateAdded(),
                "Candidate was not added successfully"
        );
    }

    @Test(enabled = false)
    public void shortlistCandidate() {

        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);

        loginAsAdmin();

        recruitmentPage.clickRecruitment();
        recruitmentPage.searchCandidate("Allen");
        recruitmentPage.clickCandidateView();

        recruitmentPage.clickShortlist();
        recruitmentPage.saveShortlist();
    }

    @Test (enabled = false)
    public void scheduleInterview() {

        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);

        loginAsAdmin();

        recruitmentPage.clickRecruitment();

        recruitmentPage.searchCandidate("Allen");
        recruitmentPage.clickCandidateView();

        recruitmentPage.clickShortlist();
        recruitmentPage.saveShortlist();

        recruitmentPage.clickScheduleInterview();

        recruitmentPage.enterInterviewTitle("QA Automation Interview");
        recruitmentPage.selectInterviewer("Admin");
        recruitmentPage.enterInterviewDate("2026-09-30");
        recruitmentPage.enterInterviewTime("10:00");
        recruitmentPage.enterInterviewNotes(
                "Technical interview for QA position"
        );
        recruitmentPage.saveInterview();
    }

}