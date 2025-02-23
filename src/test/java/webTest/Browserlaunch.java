package webTest;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Browserlaunch {

    private static final Logger log = LoggerFactory.getLogger(Browserlaunch.class);
    private WebDriver driver;

    @BeforeTest
    @Step("Setting up the WebDriver and launching the browser")
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        log.info("Chrome browser launched successfully.");
    }

    @Test(description = "Google Search Test")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to verify Google search functionality.")
    @Epic("EP001")
    @Feature("Feature: Google Search")
    @Story("Story: User searches in Google")
    public void googleSearchTest() {
        log.info("Navigating to Google...");
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();
        log.info("Search submitted.");

        Assert.assertTrue(driver.getTitle().contains("Selenium WebDriver"));
    }

    @AfterTest
    @Step("Closing the browser")
    public void teardown() {
        if (driver != null) {
            driver.quit();
            log.info("Browser closed.");
        }
    }
}
