import listeners.TestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import pageObjects.google.GoogleSearchPage;
import pageObjects.google.GoogleSearchResultsPage;

@RunWith(TestRunner.class)
public class GoogleTests extends BaseTest {

    @Test
    public void verifyLinkPresentOnFirstPage() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.openPage();
        GoogleSearchResultsPage googleSearchResultsPage =
                googleSearchPage.searchInGoogle("selenium automation testing");
        googleSearchResultsPage.verifyLinkPrescense("https://www.seleniumhq.org/", true);
    }


    @Test
    public void verifyLinkPresentOnSeventeenPage() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.openPage();
        GoogleSearchResultsPage googleSearchResultsPage =
                googleSearchPage.searchInGoogle("elementary physics");
        googleSearchResultsPage.navigateToPageWithNextButton(17  );
        googleSearchResultsPage.verifyLinkPrescense("http://open-encyclopedia.com/Physics", true);
    }

    @Test
    public void verifyLinkDoesNotPresent() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.openPage();
        GoogleSearchResultsPage googleSearchResultsPage =
                googleSearchPage.searchInGoogle("абракадабра");
        googleSearchResultsPage.navigateToPage(2 );
        googleSearchResultsPage.verifyLinkPrescense("kpi.ua", false);
    }

}
