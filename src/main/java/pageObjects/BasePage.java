package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static org.openqa.selenium.support.PageFactory.initElements;
import static utils.DriverManager.getDriverManager;

import java.util.List;

public class BasePage {

    private static WebDriver driver = getDriverManager().getDriver();

    private static Actions driverActions = new Actions(driver);

    public BasePage() {
        initElements(driver, this);
    }

    protected WebElement findElementByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    protected List<WebElement> findElementsByXpath(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

    protected void openPage(String endpoint) {
        driver.navigate().to(endpoint);
    }

    protected void enterText(WebElement webElement, String text) {
        driverActions.sendKeys(webElement, text).perform();
    }

    protected void pressEnter() {
        driverActions.sendKeys(Keys.ENTER).perform();
    }

    protected void moveToElement(WebElement element) {
        driverActions.moveToElement(element).perform();
    }
}
