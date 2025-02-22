package webTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browserlaunch {
    public static void main(String[] args) {
        // Set up WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open Google
            driver.get("https://www.google.com");

            // Maximize the window
            driver.manage().window().maximize();

            // Find the search box and enter a query
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium WebDriver");

            // Submit the search
            searchBox.submit();

            // Wait for results to load (basic sleep for demo; use WebDriverWait in real cases)
            Thread.sleep(3000);

            // Print page title
            System.out.println("Page Title: " + driver.getTitle());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser
            driver.quit();
        }
    }
}

//package webTest;
//import org.openqa.selenium.*;
//        import org.openqa.selenium.chrome.ChromeDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class BrowserLaunch {
//    public static void main(String[] args) throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.google.com");
//        driver.manage().window().maximize();
//        driver.findElement(By.name("q")).sendKeys("Selenium WebDriver", Keys.ENTER);
//        Thread.sleep(3000);
//        System.out.println("Page Title: " + driver.getTitle());
//        driver.quit();
//    }
//}
