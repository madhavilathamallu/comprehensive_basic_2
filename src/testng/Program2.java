package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Program2 {

    private WebDriver driver;

    @Test(priority = 1)
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aravi\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.automationanywhere.com/");
    }

    @Test(priority = 2)
    public void handleCookiePopup() {
        WebElement acceptCookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookiesButton.click();
    }

    @Test(priority = 3)
    public void verifyLinksAndNavigation() {
        String[] linkTexts = {"Products", "Solutions", "Resources", "Beyond RPA", "Company"};
        String[] expectedURLs = {
            "https://www.automationanywhere.com/products",
            "https://www.automationanywhere.com/solutions",
            "https://www.automationanywhere.com/resources",
            "https://www.automationanywhere.com/rpa/robotic-process-automation",
            "https://www.automationanywhere.com/company/about-us"
        };

        for (int i = 0; i < linkTexts.length; i++) {
            WebElement link = driver.findElement(By.linkText(linkTexts[i]));
            assert link.isDisplayed() : linkTexts[i] + " link is not present.";
            link.click();
            assert driver.getCurrentUrl().equals(expectedURLs[i]) : "Navigation to " + expectedURLs[i] + " failed.";
            driver.navigate().back();
        }
    }

    @Test(priority = 4)
    public void tearDown() {
        driver.quit();
    }
}
