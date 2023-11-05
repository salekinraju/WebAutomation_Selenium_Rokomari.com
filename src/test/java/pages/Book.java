package pages;

import basedriver.BaseDriver;
import basedriver.PageDriver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GetScreenshot;

import java.io.IOException;

public class Book extends BaseDriver {
    ExtentTest test;
    public Book(ExtentTest test){
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }

    @FindBy(xpath = "//body/div[7]/section[1]/section[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/a[2]")
    WebElement addToCart;
    @FindBy(xpath = "//*[@id='cart-icon']")
    WebElement cart;



    public void failCase(String msg, String scName) throws IOException {
        test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>"+msg+"</b></p>");
        Throwable t = new InterruptedException("Exception");
        test.fail(t);
        String screenShotPath = GetScreenshot.capture(PageDriver.getCurrentDriver(),""+scName+"");
        String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
        test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
        PageDriver.getCurrentDriver().quit();
    }
    public void passCase(String msg) {
        test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+msg+"</b></p>");
    }

    public void passCaseWithSC(String msg, String scName) throws IOException {
        test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+msg+"</b></p>");
        String screenShotPath = GetScreenshot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
        String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
        test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
    }

    public void book() throws IOException {
        try {
            test.info("Add book to the cart");
            if (addToCart.isDisplayed()){
                addToCart.click();
                Thread.sleep(3000);
                cart.click();
                Thread.sleep(3000);
            }

        }
        catch (Exception e){
            failCase("Could not add book to the cart", "bookCartFail");
        }
    }
}