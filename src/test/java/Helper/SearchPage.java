package Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPage {

	public WebElement searchBox = Browser.driver.findElement(By.xpath("//*[@id=\'twotabsearchtextbox\']"));
	public WebElement searchBtn = Browser.driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]"));

	public WebElement selectItem(int itemIndex) {
		String select_prodcut_css = "div[data-index='" + itemIndex + "'";
		WebElement selectedItem = Browser.driver.findElement(By.cssSelector(select_prodcut_css));
		return selectedItem;
	}

	public String get_item_price(WebElement selectedItem) {
		String price_symbol = selectedItem.findElement(By.className("a-price-symbol")).getText();
		String price_whole = selectedItem.findElement(By.className("a-price-whole")).getText();
		String price_fraction = selectedItem.findElement(By.className("a-price-fraction")).getText();
		String price_decimal = selectedItem.findElement(By.className("a-price-decimal")).getText();
		String price = price_symbol + price_whole + "." + price_fraction;
		return price;
	}

	public String get_item_price(int itemIndex) {
		WebElement selectedItem = selectItem(itemIndex);
		String price_symbol = selectedItem.findElement(By.className("a-price-symbol")).getText();
		String price_whole = selectedItem.findElement(By.className("a-price-whole")).getText();
		String price_fraction = selectedItem.findElement(By.className("a-price-fraction")).getText();
		String price_decimal = selectedItem.findElement(By.className("a-price-decimal")).getText();
		String price = price_symbol + price_whole + "." + price_fraction;
		return price;
	}

	public String get_item_price(String searchTxt, int itemIndex) {
		searchBox.sendKeys(searchTxt);
		searchBtn.click();
		WebElement selectedItem = selectItem(itemIndex);
		String price_symbol = selectedItem.findElement(By.className("a-price-symbol")).getText();
		String price_whole = selectedItem.findElement(By.className("a-price-whole")).getText();
		String price_fraction = selectedItem.findElement(By.className("a-price-fraction")).getText();
		String price_decimal = selectedItem.findElement(By.className("a-price-decimal")).getText();
		String price = price_symbol + price_whole + "." + price_fraction;
		return price;
	}

	public void click_item(WebElement selectedItem) {
		selectedItem.findElement(By.tagName("a")).click();
	}

	public void click_item(int itemIndex) {
		WebElement selectedItem = selectItem(itemIndex);
		selectedItem.findElement(By.tagName("a")).click();
	}

	public String click_item(String searchTxt, int itemIndex) {
		searchBox.sendKeys(searchTxt);
		searchBtn.click();
		WebElement selectedItem = selectItem(itemIndex);
		String price = get_item_price(selectedItem);

		selectedItem.findElement(By.tagName("a")).click();
		return price;
	}
}
