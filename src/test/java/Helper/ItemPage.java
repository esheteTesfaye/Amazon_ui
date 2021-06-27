package Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ItemPage {
	String itemPriceXpath = "//*[@id=\"newBuyBoxPrice\"]";
	String addToCartXpath = "//*[@id=\"add-to-cart-button\"]";

	public String get_item_price() {
		WebElement itemPrice = Browser.driver.findElement(By.xpath(itemPriceXpath));
		String item_price = itemPrice.getText();
		return item_price;
	}

	public void add_to_cart() {
		WebElement addToCartBtn = Browser.driver.findElement(By.xpath(addToCartXpath));
		addToCartBtn.click();
	}

}
