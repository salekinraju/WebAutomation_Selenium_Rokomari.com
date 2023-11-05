package tests;

import basedriver.BaseDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PlaceOrder;
import utilities.ExtentFactory;

import java.io.IOException;

public class PlaceOrderTest extends BaseDriver {
    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;
    @BeforeClass
    public void start() throws InterruptedException {
        report = ExtentFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Rokomari Place Order</b></p>").assignAuthor("Salekin").assignDevice("Chrome");
    }
    @Test
    public void placeOrderTest() throws IOException, InterruptedException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>PlaceOrder</b></p>");
        PlaceOrder placeOrder = new PlaceOrder(childTest);
        placeOrder.placeOrder();
        Thread.sleep(5000);
    }
    @AfterClass
    public void report(){
        report.flush();
    }
}
