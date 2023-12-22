package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class WebDriverInstance {

    private static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        if ("chrome".equalsIgnoreCase(browser)) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            driver = new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser name: " + browser);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
//        if (driver == null) {
//            switch (browser){
//                case "chrome":
//                    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
//                    driver = new ChromeDriver();
//                    break;
//
//                case "firefox":
//                    System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
//                    driver = new FirefoxDriver();
//                    break;
//            }
//        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
