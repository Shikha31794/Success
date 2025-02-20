package driver;

import io.github.bonigarcia.wdm.WebDriverManager; // Import WebDriverManager for automatic driver management
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManagerI {

    public static WebDriver initializeDriver(String browser) {
        WebDriver driver;

        // Set up WebDriverManager to automatically download the correct ChromeDriver version
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup(); // Fix typo here
            driver = new ChromeDriver(); // Initialize ChromeDriver

        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver(); // Initialize FirefoxDriver

        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser); // Throw exception for unsupported browsers
        }

        // Optional: Uncomment these lines if you need to set timeouts or maximize the window
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // driver.manage().window().maximize();

        return driver;
    }
}
