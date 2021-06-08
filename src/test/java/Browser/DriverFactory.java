package Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static utills.PropertyReader.getProperty;

public class DriverFactory {

    public static WebDriver getDriver() {

        WebDriver driver = null;
        String browser = getProperty("browser");

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Invalid browser name");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

}
