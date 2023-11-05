package pages;

import basedriver.BaseDriver;
import basedriver.PageDriver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.GetScreenshot;

import java.io.IOException;

public class PlaceOrder extends BaseDriver {
    ExtentTest test;
    public PlaceOrder(ExtentTest test){
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }

    @FindBy(xpath = "//body/div[@id='shipping-payment']/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[2]/fieldset[1]/input[1]")
    WebElement name;
    @FindBy(xpath = "//body/div[@id='shipping-payment']/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[2]/div[1]/fieldset[1]/input[1]")
    WebElement phone;
    @FindBy(xpath = "//body/div[@id='shipping-payment']/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[2]/div[1]/fieldset[2]/input[1]")
    WebElement alternativePhone;
    @FindBy(xpath = "//select[@id='js--city']")
    WebElement city;
    @FindBy(xpath = "//select[@id='js--area']")
    WebElement area;
    @FindBy(xpath = "//select[@id='js--zone']")
    WebElement zone;
    @FindBy(xpath = "//body/div[@id='shipping-payment']/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[2]/fieldset[2]/textarea[1]")
    WebElement address;
    @FindBy(xpath = "//body/div[@id='shipping-payment']/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[2]/div[1]/div[1]/label[1]/img[1]")
    WebElement bkashLocation;
    @FindBy(xpath = "//body/div[@id='shipping-payment']/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[2]/div[1]/div[1]/label[1]")
    WebElement clickBkash;
    @FindBy(xpath = "//label[contains(text(),'এই শর্তগুলো মেনে অর্ডার প্রদান করছি।')]")
    WebElement termsLocation;
    @FindBy(xpath = "//label[contains(text(),'এই শর্তগুলো মেনে অর্ডার প্রদান করছি।')]")
    WebElement clickTerms;

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

    public void placeOrder() throws IOException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            test.info("Enter Name.");
            if (name.isDisplayed()){
                name.clear();
                name.sendKeys("Md. Sirajus Salekin Raju");
                Thread.sleep(3000);
                passCase("Name Entered.");

                try {
                    test.info("Enter Phone Number");
                    if (phone.isDisplayed()){
                        phone.sendKeys("01780802976");
                        Thread.sleep(2000);
                        alternativePhone.sendKeys("01521469166");
                        Thread.sleep(3000);
                        passCase("Phone Number Entered.");

                        try {
                            test.info("Select City");
                            if (city.isDisplayed()){
                                Select select = new Select(city);
                                select.selectByVisibleText("ঠাকুরগাঁও ");
                                Thread.sleep(3000);
                                passCase("City selected.");

                                try {
                                    test.info("Select area.");
                                    if (area.isDisplayed()){
                                        Select select1 = new Select(area);
                                        select1.selectByVisibleText("ঠাকুরগাঁও সদর");
                                        Thread.sleep(3000);
                                        passCase("Area selected.");

                                        try {
                                            test.info("Select zone.");
                                            if (zone.isDisplayed()){
                                                Select select2 = new Select(zone);
                                                select2.selectByVisibleText("ঠাকুরগাও পৌরসভা ");
                                                Thread.sleep(3000);
                                                passCase("Zone selected.");

                                                try {
                                                    test.info("Enter address.");
                                                    if (address.isDisplayed()){
                                                        address.sendKeys("Hallpara");
                                                        Thread.sleep(3000);
                                                        passCase("Address entered.");

                                                        try {
                                                            test.info("Select payment method and agree terms.");
                                                            if (bkashLocation.isDisplayed()){
                                                                js.executeScript("arguments[0].scrollIntoView(true);", bkashLocation);
                                                                clickBkash.click();
                                                                Thread.sleep(3000);
                                                                js.executeScript("arguments[0].scrollIntoView(true);", termsLocation);
                                                                Thread.sleep(5000);
                                                                clickTerms.click();
                                                                Thread.sleep(5000);
                                                                passCase("Payment method selected and terms agreed.");
                                                            }

                                                        } catch (Exception e){
                                                            failCase("Could not find payment method and terms checkbox.", "paymentTermsFail");
                                                        }
                                                    }

                                                } catch (Exception e){
                                                    failCase("Could not find address field", "addressFail");
                                                }
                                            }

                                        } catch (Exception e){
                                            failCase("Could not find zone field", "zoneFail");
                                        }

                                    }

                                } catch (Exception e){
                                    failCase("Could not find area field", "areaFail");
                                }
                            }

                        } catch (Exception e){
                            failCase("Could not find city field", "cityFail");
                        }
                }

            } catch (Exception e){
                    failCase("Could not find phone number field", "phoneFail");
                }
            }

        }
        catch (Exception e){
            failCase("Could not find name field.", "nameFail");
        }
    }
}
