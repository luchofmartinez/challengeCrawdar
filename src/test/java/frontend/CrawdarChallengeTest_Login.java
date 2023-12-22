package frontend;


import com.aventstack.extentreports.Status;
import driver.WebDriverInstance;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.Date;

import static utils.SeleniumUtils.printPantalla;

public class CrawdarChallengeTest_Login extends CrawdarChallengeTest_BasePage
{
    CrowdarChallengeLoginPage loginPage;

    @BeforeTest
    public void startReport(){
        inicializarReporte("Login");
    }

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser){
        webDriver = WebDriverInstance.getDriver(browser);
        webDriver.manage().window().maximize();
        webDriver.get("https://www.saucedemo.com/");
    }

    @Test
    public void CrawdarChallenge_LoginOk() {
        test = extent.createTest("Login OK", "Valido que este ok el login");
        Date a = new Date();
        try{
            loginPage = new CrowdarChallengeLoginPage(webDriver);
            loginPage.enterUsername("standard_user");
            loginPage.enterPassword("secret_sauce");
            loginPage.clickLogin();
            Thread.sleep(5000);
            test.log(Status.PASS,"test");

        }catch (Exception ex){
            printPantalla(webDriver, "Error_"+ a.getTime()+".png");
            test.log(Status.FAIL,"test");
        }
    }

    @Test
    public void CrawdarChallenge_LoginError() {
        test = extent.createTest("Login Con Error  ", "Valido que este haya error en el login");
        Date a = new Date();
        try{
            loginPage = new CrowdarChallengeLoginPage(webDriver);
            loginPage.enterUsername("locked_out_user");
            loginPage.enterPassword("secret_sauce");
            loginPage.clickLogin();
            Thread.sleep(2000);
            if(loginPage.existLockedUserMessage()){
                throw new Exception() ;
            }
            test.log(Status.PASS,"");
        }catch (Exception ex){
            printPantalla(webDriver, "Error_"+ a.getTime()+".png");
            test.log(Status.FAIL,"");
        }
    }
    @AfterMethod
    public void endTest(){
        webDriver.quit();
    }

    @AfterTest
    public void endReport(){
        extent.flush();
    }
}
