package utils;

import static java.lang.Long.parseLong;
import static java.lang.System.setProperty;
import static java.util.Optional.ofNullable;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static utils.Constants.WebDriverProperties.CHROME_DRIVER;
import static utils.Constants.WebDriverProperties.EDGE_DRIVER;
import static utils.Constants.WebDriverProperties.FIREFOX_DRIVER;
import static utils.PropertyLoader.getProperty;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static final DriverManager driverManager = new DriverManager();

    private DriverManager() {}

    public static DriverManager getDriverManager() {
        return driverManager;
    }


    @Getter
    private WebDriver driver;

    public WebDriver getWebDriverInstance() {
        String browser = getProperty("browser");
            switch (browser) {
                case "Chrome":
                    setProperty(CHROME_DRIVER.value, getProperty(CHROME_DRIVER.value));
                    ChromeOptions options = getChromeOptionsWithNotificationDisabling();
                    driver = new ChromeDriver(options);
                    break;
                case "Edge":
                    System.setProperty(EDGE_DRIVER.value, getProperty(EDGE_DRIVER.value));
                    driver = new EdgeDriver();
                    break;
                case "Firefox":
                    System.setProperty(FIREFOX_DRIVER.value, getProperty(FIREFOX_DRIVER.value));
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new NoSuchElementException("Provided driver is not supported. Supported values are: Chrome, Firefox, Edge");
        }
        return driver;
    }

    private ChromeOptions getChromeOptionsWithNotificationDisabling() {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        return options;
    }

    public void setPropertyWindow(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(parseLong(getProperty("page.load.time")), TimeUnit.SECONDS);
    }

    public void tearDownWebDriver(WebDriver driver) {
        ofNullable(driver).ifPresent(WebDriver::close);
    }

}
