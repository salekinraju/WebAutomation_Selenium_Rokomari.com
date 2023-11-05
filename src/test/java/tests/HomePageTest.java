package tests;

import basedriver.BaseDriver;
import basedriver.PageDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ExtentFactory;

import java.io.IOException;

public class HomePageTest extends BaseDriver {
    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;
    @BeforeClass
    public void start() throws InterruptedException {
        PageDriver.getCurrentDriver().get(url);
        //Thread.sleep(5000);
        report = ExtentFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Rokomari Home</b></p>").assignAuthor("Salekin").assignDevice("Chrome");
    }
    @Test
    public void homePageTest() throws IOException, InterruptedException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Home</b></p>");
        HomePage homePage = new HomePage(childTest);
        homePage.signIn();
        Thread.sleep(3000);
    }
    @AfterClass
    public void report(){
        report.flush();
    }
}
