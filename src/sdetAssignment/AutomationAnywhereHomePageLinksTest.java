package sdetAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationAnywhereHomePageLinksTest {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Madhu-Learning\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.automationanywhere.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement acceptCookiesButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
		acceptCookiesButton.click();

		String[] linkTexts = { "Products", "Solutions", "Resources", "Beyond RPA", "Company" };

		for (String linkText : linkTexts) {

			WebElement link = driver.findElement(By.linkText(linkText));

			if (link != null) {
				link.click();
				System.out.println("Clicked on " + linkText);

				String expectedURL = getExpectedURL(linkText);
				if (driver.getCurrentUrl().equals(expectedURL)) {
					System.out.println("Navigated to the proper page: " + expectedURL);
				} else {
					System.out.println("Navigation to " + expectedURL + " failed.");
				}

				driver.navigate().back();
			} else {
				System.out.println(linkText + " link not found.");
			}
		}

		driver.quit();
	}

	private static String getExpectedURL(String linkText) {
		switch (linkText) {
		case "Products":
			return "https://www.automationanywhere.com/products";
		case "Solutions":
			return "https://www.automationanywhere.com/solutions";
		case "Resources":
			return "https://www.automationanywhere.com/resources";
		case "Beyond RPA":
			return "https://www.automationanywhere.com/rpa/robotic-process-automation";
		case "Company":
			return "https://www.automationanywhere.com/company/about-us";
		default:
			return "";
		}
	}
}
