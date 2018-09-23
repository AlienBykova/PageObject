import lombok.SneakyThrows;
import org.junit.Test;
import pageObjects.clothesShop.ClosesMainPage;
import pageObjects.clothesShop.WomenClosesPage;

public class ClosesShopTests extends BaseTest {

    @Test
    public void verifyAscendingPriceSort() {
        ClosesMainPage closesMainPage = new ClosesMainPage();
        closesMainPage.open();
        WomenClosesPage womenClosesPage = closesMainPage.navigateToWomenTab();
        womenClosesPage.selectSortByAscendingPrice();
        womenClosesPage.verifyPriceSortedByAscending();

    }

    @Test
    @SneakyThrows
    public void verifyColorSorting() {
        ClosesMainPage closesMainPage = new ClosesMainPage();
        closesMainPage.open();
        WomenClosesPage womenClosesPage = closesMainPage.navigateToWomenTab();
        womenClosesPage.selectOrangeColorFilter();
        womenClosesPage.verifyNumberOfItemsAfterFiltering();
    }
}
