package tests;

import basedriver.BaseDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SelectBook;
import utilities.ExtentFactory;

import java.io.IOException;

public class SelectBookTest extends BaseDriver {
    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;
    @BeforeClass
    public void start() throws InterruptedException {
        report = ExtentFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Rokomari Book Selection</b></p>").assignAuthor("Salekin").assignDevice("Chrome");
    }
    @Test
    public void selectBookTest() throws IOException, InterruptedException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>SelectBook</b></p>");
        SelectBook selectBook = new SelectBook(childTest);
        selectBook.selectBook();
        Thread.sleep(3000);
    }
    @AfterClass
    public void report(){
        report.flush();
    }
}
