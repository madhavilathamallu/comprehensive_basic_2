package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Program1 {

    private WebDriver driver;

    @Test(priority = 1)
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:/Madhu-Learning/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.automationanywhere.com/");
    }

    @Test(priority = 2)
    public void verifyLogo() {
        WebElement logo = driver.findElement(By.xpath("//img[@alt='Automation Anywhere']"));
        assert logo.isDisplayed() : "Automation Anywhere logo is not present.";
    }

    @Test(priority = 3)
    public void verifyRequestDemoButton() {
        WebElement requestDemoButton = driver.findElement(By.xpath("//a[text()='Request demo']"));
        assert requestDemoButton.isDisplayed() : "Request demo button is not present.";
        assert requestDemoButton.isEnabled() : "Request demo button is not clickable.";
    }

    @Test(priority = 4)
    public void tearDown() {
        driver.quit();
    }
}
