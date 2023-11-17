package tests;

import basedriver.BaseDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SelectedAuthor;
import utilities.ExtentFactory;

import java.io.IOException;

public class SelectedAuthorTest extends BaseDriver {
    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;
    @BeforeClass
    public void start() {
        report = ExtentFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Rokomari Selected Author</b></p>").assignAuthor("Salekin").assignDevice("Chrome");
    }
    @Test
    public void selectedAuthorTest() throws IOException, InterruptedException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>SelectedAuthor</b></p>");
        SelectedAuthor selectedAuthor = new SelectedAuthor(childTest);
        selectedAuthor.authorSelected();
        Thread.sleep(5000);
    }
    @AfterClass
    public void report(){
        report.flush();
    }
}
