package Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartPage {
	String totalPriceXpath = "//*[@id=\"sc-subtotal-amount-buybox\"]/span";
	String cartBtnXpath = "//*[@id=\"nav-cart-count\"]";

	public String get_item_price() {
		WebElement totalPrice = Browser.driver.findElement(By.xpath(totalPriceXpath));
		String item_price = totalPrice.getText();
		return item_price;
	}

	public void open_cart() {
		WebElement cartBtn = Browser.driver.findElement(By.xpath(cartBtnXpath));
		cartBtn.click();
	}

}
