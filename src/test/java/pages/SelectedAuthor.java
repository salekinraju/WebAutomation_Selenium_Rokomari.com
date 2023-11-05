package pages;

import basedriver.BaseDriver;
import basedriver.PageDriver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GetScreenshot;

import java.io.IOException;

public class SelectedAuthor extends BaseDriver {
    ExtentTest test;
    public SelectedAuthor(ExtentTest test){
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }

    @FindBy(xpath = "//label[contains(text(),'Price - Low to High')]")
    WebElement scrollToFilter;
    @FindBy(xpath = "//label[contains(text(),'উপন্যাস সমগ্র')]")
    WebElement category1;
    @FindBy(xpath = "//label[contains(text(),'Price - Low to High')]")
    WebElement scrollToFilter2;
    @FindBy(xpath = "//label[contains(text(),'শিশু-কিশোর উপন্যাস')]")
    WebElement category2;
    @FindBy(xpath = "//body/div[6]/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[57]/div[1]/a[1]/div[1]/img[1]")
    WebElement scrollLocation;
    @FindBy(xpath = "//a[contains(text(),'Next')]")
    WebElement nextPage;

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

    public void authorSelected() throws IOException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions action = new Actions(driver);
        try {
            test.info("Select category and go to next page.");
            if (scrollToFilter.isDisplayed()){
                js.executeScript("arguments[0].scrollIntoView(true);", scrollToFilter);
                Thread.sleep(2000);
                category1.click();
                Thread.sleep(3000);
                js.executeScript("arguments[0].scrollIntoView(true);", scrollToFilter2);
                Thread.sleep(2000);
                category2.click();
                Thread.sleep(3000);
                js.executeScript("arguments[0].scrollIntoView(true);", scrollLocation);
                Thread.sleep(5000);
                nextPage.click();
                Thread.sleep(3000);
                passCaseWithSC("Next page clicked", "nextPage");

            }

        }
        catch (Exception e){
            failCase("Could not go to next page!", "nextFail");
        }
    }
}
