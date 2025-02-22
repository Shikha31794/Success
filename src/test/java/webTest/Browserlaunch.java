package webTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Browserlaunch {
    // Use SLF4J Logger
    private static final Logger log = LoggerFactory.getLogger(Browserlaunch.class);

    public static void main(String[] args) {
        log.info("Setting up Chrome WebDriver...");

        // Set up WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        log.info("Chrome browser launched successfully.");

        try {
            // Open Google
            driver.get("https://www.google.com");
            log.info("Navigated to Google.");

            // Maximize the window
            driver.manage().window().maximize();
            log.info("Browser window maximized.");

            // Find the search box and enter a query
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium WebDriver");
            log.info("Entered 'Selenium WebDriver' in search box.");

            // Submit the search
            searchBox.submit();
            log.info("Search submitted.");

            // Wait for results to load (basic sleep for demo; use WebDriverWait in real cases)
            Thread.sleep(3000);

            // Print page title
            String pageTitle = driver.getTitle();
            log.info("Page Title: {}", pageTitle);

        } catch (Exception e) {
            log.error("An error occurred: ", e);
        } finally {
            // Close browser
            driver.quit();
            log.info("Browser closed.");
        }
    }
}
