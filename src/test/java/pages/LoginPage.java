package pages;

import basedriver.PageDriver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GetScreenshot;

import java.io.IOException;

public class LoginPage {
    ExtentTest test;
    public LoginPage(ExtentTest test){
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }

    @FindBy(xpath = "//input[@name=\"username\"]")
    WebElement email;
    @FindBy(xpath = "//button[@id='js--btn-next']")
    WebElement next;
    @FindBy(xpath = "//input[@type=\"password\"]")
    WebElement password;
    @FindBy(xpath = "//body/div[@id='login-registration']/div[1]/section[1]/div[1]/div[2]/div[2]/form[1]/button[1]")
    WebElement login;

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

    public void logIn() throws IOException {
        try {
            test.info("Enter email.");
            if (email.isDisplayed()){
                email.sendKeys("salekinraju@gmail.com");
                next.click();
                Thread.sleep(3000);
                passCase("Email Entered.");

                try {
                    test.info("Enter Password");
                    if (password.isDisplayed()){
                        password.sendKeys("abc123abc");
                        login.click();
                        Thread.sleep(3000);
                        passCaseWithSC("Password entered.", "password");
                }

            } catch (Exception e){
                    failCase("Could not find password field", "passwordFail");
                }
            }

        }
        catch (Exception e){
            failCase("Could not find email field.", "emailFail");
        }
    }
}
