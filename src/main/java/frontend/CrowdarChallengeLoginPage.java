package frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CrowdarChallengeLoginPage {

    private WebDriver driver;

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    private By lockedUserMessage = By.className("error-message-container");


    public CrowdarChallengeLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }
    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean existLockedUserMessage(){
        return driver.findElement(lockedUserMessage).isDisplayed();
    }
}
