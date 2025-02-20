package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileDriverManager {

    public static AppiumDriver initializeDriver(String platform) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (platform.equalsIgnoreCase("android")) {
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "13");

            capabilities.setCapability("deviceName", "Galaxy A32");  // Actual device name
            capabilities.setCapability("automationName", "UiAutomator2");  // Android automation engine
            capabilities.setCapability("app", "/Users/b0226036/Desktop/app-default-debug.apk");
            capabilities.setCapability("appPackage", "com.example.airtelads");
            capabilities.setCapability("appActivity", "com.example.airtelads.ui.MainActivity");

            return new AndroidDriver(new URL(getAppiumServerURL()), capabilities);
        } else if (platform.equalsIgnoreCase("ios")) {
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("automationName", "XCUITest");  // iOS automation engine
            capabilities.setCapability("deviceName", "iPhone Simulator");  // Simulator or device name
            capabilities.setCapability("app", "/path/to/ios-app.ipa");

            return new IOSDriver(new URL(getAppiumServerURL()), capabilities);
        } else {
            throw new IllegalArgumentException("Unsupported platform: " + platform);
        }
    }

    private static String getAppiumServerURL() {
        return "http://127.0.0.1:4723/wd/hub";  // This could be fetched from environment variables or config
    }
}
