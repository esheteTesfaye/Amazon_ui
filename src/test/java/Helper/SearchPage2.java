package Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage2 {
	WebDriver driver;

	public SearchPage2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\'twotabsearchtextbox\']")
	public WebElement searchBox;

	@FindBy(xpath = "//*[@id=\"nav-search-submit-button\"]")
	public WebElement searchBtn;

	public WebElement selectItem(int itemIndex) {
		String select_prodcut_css = "div[data-index='" + itemIndex + "'";
		WebElement selectedItem = driver.findElement(By.cssSelector(select_prodcut_css));
		return selectedItem;
	}

	public Double get_item_price(WebElement selectedItem) {
		String price_symbol = selectedItem.findElement(By.className("a-price-symbol")).getText();
		String price_whole = selectedItem.findElement(By.className("a-price-whole")).getText();
		String price_decimal = selectedItem.findElement(By.className("a-price-decimal")).getText();
		String price = price_symbol + price_whole + "." + price_decimal;
		return Double.parseDouble(price);
	}

}
