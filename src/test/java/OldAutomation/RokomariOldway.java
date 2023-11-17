package OldAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class RokomariOldway extends browserSetup{
    String url = "https://www.rokomari.com/book";

    @Test

    public void rokomariTest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(url);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //homepage
        WebElement signIn = driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
        signIn.click();
        Thread.sleep(3000);
        //sign in page
        WebElement email = driver.findElement(By.xpath("//input[@name=\"username\"]"));
        email.sendKeys("salekinraju@gmail.com");
        Thread.sleep(3000);
        WebElement next = driver.findElement(By.xpath("//button[@id='js--btn-next']"));
        next.click();
        Thread.sleep(3000);
        WebElement password = driver.findElement(By.xpath("//input[@type=\"password\"]"));
        password.sendKeys("abc123abc");
        Thread.sleep(3000);
        WebElement login = driver.findElement(By.xpath("//body/div[@id='login-registration']/div[1]/section[1]/div[1]/div[2]/div[2]/form[1]/button[1]"));
        login.click();
        Thread.sleep(3000);

        Actions action = new Actions(driver);
        WebElement writer = driver.findElement(By.xpath("//a[@id='js--authors']"));
        WebElement humayun = driver.findElement(By.xpath("//a[contains(text(),'হুমায়ূন আহমেদ')]"));
        action.moveToElement(writer).perform();
        Thread.sleep(3000);
        action.moveToElement(humayun).perform();
        Thread.sleep(3000);
        humayun.click();
        Thread.sleep(5000);

        WebElement scrollToFilter = driver.findElement(By.xpath("//label[contains(text(),'Price - Low to High')]"));
        js.executeScript("arguments[0].scrollIntoView(true);", scrollToFilter);
        Thread.sleep(5000);
        WebElement category1 = driver.findElement(By.xpath("//label[contains(text(),'উপন্যাস সমগ্র')]"));
        category1.click();
        Thread.sleep(3000);
        WebElement scrollToFilter2 = driver.findElement(By.xpath("//label[contains(text(),'Price - Low to High')]"));
        js.executeScript("arguments[0].scrollIntoView(true);", scrollToFilter2);
        Thread.sleep(5000);
        WebElement category2 = driver.findElement(By.xpath("//label[contains(text(),'শিশু-কিশোর উপন্যাস')]"));
        category2.click();
        Thread.sleep(3000);
        WebElement scrollLocation = driver.findElement(By.xpath("//body/div[6]/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[54]/div[1]/a[1]"));
        js.executeScript("arguments[0].scrollIntoView(true);", scrollLocation);
        Thread.sleep(5000);
        WebElement nextPage = driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
        nextPage.click();
        Thread.sleep(3000);

        WebElement selectBook = driver.findElement(By.xpath("//body/div[6]/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[3]/div[1]/a[1]"));
        action.moveToElement(selectBook).perform();
        Thread.sleep(3000);
        WebElement gotoBook = driver.findElement(By.xpath("//body/div[6]/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[3]/div[1]/div[1]/a[1]"));
        gotoBook.click();
        Thread.sleep(3000);

        WebElement addToCart = driver.findElement(By.xpath("//body/div[7]/section[1]/section[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/a[2]/span[1]"));
        addToCart.click();
        Thread.sleep(2000);
        WebElement cart = driver.findElement(By.xpath("//*[@id='cart-icon']"));
        cart.click();
        Thread.sleep(3000);

        WebElement placeOrder = driver.findElement(By.xpath("//a[@id='js-continue-to-shipping']"));
        placeOrder.click();
        Thread.sleep(3000);

        WebElement name = driver.findElement(By.xpath("//body/div[@id='shipping-payment']/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[2]/fieldset[1]/input[1]"));
        name.clear();
        name.sendKeys("Salekin Raju");
        Thread.sleep(2000);
        WebElement phone = driver.findElement(By.xpath("//body/div[@id='shipping-payment']/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[2]/div[1]/fieldset[1]/input[1]"));
        phone.sendKeys("01780802976");
        Thread.sleep(2000);
        WebElement alternativePhone = driver.findElement(By.xpath("//body/div[@id='shipping-payment']/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[2]/div[1]/fieldset[2]/input[1]"));
        alternativePhone.sendKeys("01521469166");
        Thread.sleep(2000);
        WebElement city = driver.findElement(By.xpath("//select[@id='js--city']"));
        Select select = new Select(city);
        select.selectByVisibleText("ঠাকুরগাঁও ");
        Thread.sleep(3000);
        WebElement area = driver.findElement(By.xpath("//select[@id='js--area']"));
        Select select1 = new Select(area);
        select1.selectByVisibleText("ঠাকুরগাঁও সদর");
        Thread.sleep(3000);
        WebElement zone = driver.findElement(By.xpath("//select[@id='js--zone']"));
        Select select2 = new Select(zone);
        select2.selectByVisibleText("ঠাকুরগাও পৌরসভা ");
        Thread.sleep(3000);
        WebElement address = driver.findElement(By.xpath("//body/div[@id='shipping-payment']/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[2]/fieldset[2]/textarea[1]"));
        address.sendKeys("Hallpara");
        Thread.sleep(2000);
        WebElement bkashLocation = driver.findElement(By.xpath("//body/div[@id='shipping-payment']/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[2]/div[1]/div[1]/label[1]/img[1]"));
        js.executeScript("arguments[0].scrollIntoView(true);", bkashLocation);
        Thread.sleep(5000);
        WebElement clickBkash = driver.findElement(By.xpath("//body/div[@id='shipping-payment']/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[2]/div[1]/div[1]/label[1]"));
        clickBkash.click();
        Thread.sleep(5000);
        WebElement termsLocation = driver.findElement(By.xpath("//label[contains(text(),'এই শর্তগুলো মেনে অর্ডার প্রদান করছি।')]"));
        js.executeScript("arguments[0].scrollIntoView(true);", termsLocation);
        Thread.sleep(5000);
        WebElement clickTerms = driver.findElement(By.xpath("//label[contains(text(),'এই শর্তগুলো মেনে অর্ডার প্রদান করছি।')]"));
        clickTerms.click();
        Thread.sleep(5000);

    }
}
