import org.junit.Test;
import pageObjects.facebook.FacebookLoginPage;
import pageObjects.facebook.FacebookProfileStartPage;

public class FaceBookTests extends BaseTest {

    FacebookLoginPage facebookLoginPage = new FacebookLoginPage();

    @Test
    public void loggnToFaceBook() {
        facebookLoginPage.openPage();
        FacebookProfileStartPage facebookProfileStartPage = facebookLoginPage.login();
        facebookProfileStartPage.verifyUserName("Aliena Bykova");
    }
}
