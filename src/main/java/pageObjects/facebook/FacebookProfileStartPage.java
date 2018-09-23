package pageObjects.facebook;

import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;


public class FacebookProfileStartPage extends BasePage {

    @FindBy(xpath = "//div[@id = \"userNav\"]//div[@class=\"linkWrap noCount\"]")
    WebElement userName;

    public void verifyUserName(String userName) {
        assertThat(this.userName.getText()).as("User name is not as expected").isEqualTo(userName);
    }


}
