package webTest;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Applaunch {
    public static void main(String[] args) {
        String platform = "android";  // Set platform value to "android"

        if (platform.equalsIgnoreCase("android")) {
            // Set the Desired Capabilities
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "15");  // Android version
            capabilities.setCapability("deviceName", "emulator-5554");  // Device name
            capabilities.setCapability("automationName", "UiAutomator2");  // Android automation engine
            capabilities.setCapability("app", "/Users/b0226036/Desktop/app-default-debug.apk");  // Path to the APK
            capabilities.setCapability("appPackage", "com.example.airtelads");  // App package name
            capabilities.setCapability("appActivity", "com.example.airtelads.ui.MainActivity");  // Main activity

            try {
                // Create the URL for the Appium server
                URL appiumServerUrl = new URL("http://127.0.0.1:4723/wd/hub");

                // Initialize the AndroidDriver without generic parameters
                AndroidDriver driver = new AndroidDriver(appiumServerUrl, capabilities);

                // Add a sleep to allow the app to launch and stabilize
                Thread.sleep(5000);

                // Perform any desired actions on the app here

                // Close the app
                driver.quit();
            } catch (MalformedURLException e) {
                System.out.println("Malformed URL: " + e.getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


//package webTest;
//
//import io.appium.java_client.android.AndroidDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import java.net.URL;
//
//public class AppLaunch {
//    public static void main(String[] args) {
//        try {
//            DesiredCapabilities caps = new DesiredCapabilities();
//            caps.setCapability("platformName", "Android");
//            caps.setCapability("deviceName", "emulator-5554");
//            caps.setCapability("automationName", "UiAutomator2");
//            caps.setCapability("app", "/Users/b0226036/Desktop/app-default-debug.apk");
//
//            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
//            Thread.sleep(5000);
//            driver.quit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

