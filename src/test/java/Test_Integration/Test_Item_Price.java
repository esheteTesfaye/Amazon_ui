package Test_Integration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Helper.Browser;
import Helper.CartPage;
import Helper.ItemPage;
import Helper.SearchPage;

public class Test_Item_Price {

	SearchPage searchPage;
	ItemPage itemPage;
	CartPage cartPage;

	String book = "qa testing for beginners";

	@BeforeTest()

	public void beforeClass() {

		new Browser("Chrome");
		searchPage = new SearchPage();
		itemPage = new ItemPage();
		cartPage = new CartPage();
	}

	@AfterTest
	public void afterClass() {
		Browser.driver.close();
	}

	@Test
	public void test_item_price_upto_cart() {
		/*
		 * This is to validate that item price is same on search page, item age and cart
		 * page
		 */
		// open amazon and make a search
		String price_on_search_page = searchPage.click_item(book, 1);

		// get item price on items page assert price and add into cart
		String price_on_item_page = itemPage.get_item_price();
		Assert.assertEquals(price_on_search_page, price_on_item_page);
		itemPage.add_to_cart();
		cartPage.open_cart();

		// open cart and assert price
		String price_on_cart_page = cartPage.get_item_price();
		Assert.assertEquals(price_on_search_page, price_on_cart_page);

	}

	@Test
	public void add_to_cart() {

	}

	@Test
	public void proceed_to_checkout() {

	}

}
