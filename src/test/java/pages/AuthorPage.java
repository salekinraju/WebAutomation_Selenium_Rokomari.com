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

public class AuthorPage extends BaseDriver {
    ExtentTest test;
    //WebDriver driver;

    public AuthorPage(ExtentTest test){
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }
    @FindBy(xpath = "//a[@id='js--authors']")
    WebElement writer;
    @FindBy(xpath = "//a[contains(text(),'হুমায়ূন আহমেদ')]")
    WebElement humayun;


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

    public void selectAuthor() throws IOException, InterruptedException {
        Actions action = new Actions(driver);
        try {
            test.info("Select Author.");
            if (writer.isDisplayed()){
                //Actions action = new Actions(driver);
                action.moveToElement(writer).perform();
                Thread.sleep(3000);
                action.moveToElement(humayun).perform();
                Thread.sleep(3000);
                humayun.click();
                Thread.sleep(5000);
                passCaseWithSC("Selected author.", "authorSelection");
            }

        }
        catch (Exception e){
            failCase("Could not select Author", "authorSelectionFail");
        }
    }
}