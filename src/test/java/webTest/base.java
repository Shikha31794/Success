package webTest;

import io.appium.java_client.AppiumDriver;
import driver.MobileDriverManager;
import driver.WebDriverManagerI;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class base {
    protected WebDriver webDriver;
    protected AppiumDriver mobileDriver;

    @BeforeMethod
    public void setUp(Method method) throws MalformedURLException {
        if (method.getName().toLowerCase().contains("web")) {
            webDriver = WebDriverManagerI.initializeDriver("chrome");  // Initialize web driver
        } else if (method.getName().toLowerCase().contains("mobile")) {
            mobileDriver = MobileDriverManager.initializeDriver("Android");  // Initialize mobile driver
        } else {
            throw new IllegalArgumentException("Test method name must contain 'Web' or 'Mobile' to initialize the correct driver.");
        }
    }

    @AfterMethod
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }

    }
}
