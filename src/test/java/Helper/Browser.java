package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Parameters;

public class Browser {
	public static WebDriver driver;
	public static final String URL = "https://www.amazon.com/";

	public Browser(String browserName) {
		if (browserName == "Chrome") {
			System.setProperty("webdriver.chrome.driver", utility.PathList.chromeDriver);
			driver = new ChromeDriver();

		} else if (browserName == "Firefox") {
			System.setProperty("webdriver.gecko.driver", utility.PathList.firefoxDriver);
			driver = new FirefoxDriver();

		} else {
			System.out.println("Chrome| Firfox");
		}
		driver.get(URL);

	}

}
