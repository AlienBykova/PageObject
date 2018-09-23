package pageObjects.clothesShop;

import lombok.SneakyThrows;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class WomenClosesPage extends BasePage {

    @FindBy(id = "selectProductSort")
    private WebElement sortingSelect;

    @FindBy(xpath = "//option[@value=\"price:asc\"]")
    private WebElement ascendingSort;

    @FindBy(xpath = "//option[@value=\"price:desc\"]")
    private WebElement descendingSort;

    @FindAll(@FindBy(xpath = "//ul[@class=\"product_list grid row\"]/li"))
    private List<WebElement> closesItems;

    @FindAll(@FindBy(xpath = "//ul[@class=\"product_list grid row\"]//div[@class=\"right-block\"]//span[@class=\"price product-price\"]"))
    private List<WebElement> productPrices;

    @FindBy(xpath = "//ul[@id=\"ul_layered_id_attribute_group_3\"]//li[4]//input[@type=\"button\"]")
    private WebElement orangeColorFilter;

    @FindBy(xpath = "//ul[@id=\"ul_layered_id_attribute_group_3\"]//li//a[contains(text(), \"Orange\")]/span")
    private WebElement itemNumberInOrangeFilter;

    @SneakyThrows
    public void selectOrangeColorFilter() {
        orangeColorFilter.click();
    }

    @SneakyThrows
    public void verifyNumberOfItemsAfterFiltering() {
        Thread.sleep(2000);
        int expectedNumber = Integer.valueOf(itemNumberInOrangeFilter.getText().replace("(", "").replace(")", ""));
        assertThat(closesItems.size()).as("Items size is not as expected").isEqualTo(expectedNumber);
    }

    public void verifyPriceSortedByAscending() {
        List<Float> actualPrices = productPrices.stream()
                .map(item->Float.parseFloat(item.getText().replace("$", "")))
                .collect(Collectors.toList());
        assertThat(actualPrices).as("Order of price is not as expected").isSorted();
    }


    public void selectSortByAscendingPrice() {
        sortingSelect.click();
        ascendingSort.click();
    }
}
