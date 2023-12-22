package frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CrowdarChallengeInventoryPage {

    private WebDriver driver;

    private By addToCartButton = By.xpath("//button[contains(@id,'add-to-cart')]");
    private By inventoryList = By.className("inventory_list");


    public CrowdarChallengeInventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart() {
        List<WebElement> listado = driver.findElements(inventoryList);
        listado.get(0).findElement(addToCartButton).click();
    }
}
