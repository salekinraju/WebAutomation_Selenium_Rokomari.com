package OldAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class browserSetup {
    WebDriver driver;

    @BeforeSuite
    public void startBrowser() {
        String browserName =System.getProperty("browser", "chrome");

        if(browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
    }

    @AfterSuite
    public void close() {
        driver.quit();
    }
}
