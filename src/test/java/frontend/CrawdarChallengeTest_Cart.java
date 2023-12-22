package frontend;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import driver.WebDriverInstance;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.Date;

import static utils.SeleniumUtils.printPantalla;

public class CrawdarChallengeTest_Cart extends CrawdarChallengeTest_BasePage
{
    CrowdarChallengeLoginPage loginPage;
    CrowdarChallengeInventoryPage inventoryPage;

    @BeforeTest
    public void startReport(){
        inicializarReporte("Cart");
    }

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser){
        webDriver = WebDriverInstance.getDriver(browser);
        webDriver.manage().window().maximize();
        webDriver.get("https://www.saucedemo.com/");
    }

    @Test
    public void CrawdarChallenge_Cart_AddProductOK() {
        test = extent.createTest("Agrego producto ok", "Valido que funcione el agregar al carrito");
        test.log(Status.PASS,"");
        Date a = new Date();
        try{
            loginPage = new CrowdarChallengeLoginPage(webDriver);
            loginPage.enterUsername("standard_user");
            loginPage.enterPassword("secret_sauce");
            loginPage.clickLogin();
            inventoryPage = new CrowdarChallengeInventoryPage(webDriver);
            inventoryPage.addProductToCart();
            Thread.sleep(5000);
        }catch (Exception ex){
            printPantalla(webDriver, "Error_"+ a.getTime()+".png");
        }
    }

    @Test
    public void CrawdarChallenge_Cart_AddProductError() {
        test = extent.createTest("Agregar producto da error", "Valido que este haya error al agregar al carrito");
        test.log(Status.FAIL,"");
        Date a = new Date();
        try{
            loginPage = new CrowdarChallengeLoginPage(webDriver);
            loginPage.enterUsername("standard_user");
            loginPage.enterPassword("secret_sauce");
            loginPage.clickLogin();

            inventoryPage = new CrowdarChallengeInventoryPage(webDriver);
            inventoryPage.addProductToCart();
        }catch (Exception ex){
            printPantalla(webDriver, "Error_"+ a.getTime()+".png");
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
