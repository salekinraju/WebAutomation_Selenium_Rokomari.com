package tests;

import basedriver.BaseDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ExtentFactory;

import java.io.IOException;

public class LoginPageTest extends BaseDriver {
    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;
    @BeforeClass
    public void start() throws InterruptedException {
       // PageDriver.getCurrentDriver().get(url);
        //Thread.sleep(5000);
        report = ExtentFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Rokomari Login</b></p>").assignAuthor("Salekin").assignDevice("Chrome");
    }
    @Test
    public void loginPageTest() throws IOException, InterruptedException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>LOGIN</b></p>");
        LoginPage loginPage = new LoginPage(childTest);
        loginPage.logIn();
        Thread.sleep(5000);
    }
    @AfterClass
    public void report(){
        report.flush();
    }
}
