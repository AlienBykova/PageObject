import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import static utils.DriverManager.getDriverManager;

public class BaseTest {

    private static WebDriver driver;

    @Before
    public void initDriver() {
        driver = getDriverManager().getWebDriverInstance();
        getDriverManager().setPropertyWindow(driver);
    }


    @After
    public void tearDown() {
        getDriverManager().tearDownWebDriver(driver);
    }
}
