package pages;

import basedriver.BaseDriver;
import basedriver.PageDriver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GetScreenshot;

import java.io.IOException;

public class SelectBook extends BaseDriver {
    ExtentTest test;
    public SelectBook(ExtentTest test){
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }

    @FindBy(xpath = "//body/div[6]/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[3]/div[1]/a[1]")
    WebElement selectBook;
    @FindBy(xpath = "//body/div[6]/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[3]/div[1]/div[1]/a[1]")
    WebElement gotoBook;



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

    public void selectBook() throws IOException {
        Actions action = new Actions(driver);
        try {
            test.info("Choose a book.");
            if (selectBook.isDisplayed()){
                action.moveToElement(selectBook).perform();
                Thread.sleep(3000);
                gotoBook.click();
                Thread.sleep(3000);
            }

        }
        catch (Exception e){
            failCase("Could not select a book", "bookSelectionFail");
        }
    }
}