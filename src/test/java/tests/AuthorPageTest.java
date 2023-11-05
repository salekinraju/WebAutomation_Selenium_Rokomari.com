package tests;

import basedriver.BaseDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AuthorPage;
import utilities.ExtentFactory;

import java.io.IOException;

public class AuthorPageTest extends BaseDriver {
    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;

    @BeforeClass
    public void start() throws InterruptedException {
        report = ExtentFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Rokomari Author Page</b></p>").assignAuthor("Salekin").assignDevice("Chrome");
    }
    @Test
    public void authorPageTest() throws IOException, InterruptedException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Author</b></p>");
        AuthorPage authorPage = new AuthorPage(childTest);
        authorPage.selectAuthor();
    }
    @AfterClass
    public void report(){
        report.flush();
    }
}
