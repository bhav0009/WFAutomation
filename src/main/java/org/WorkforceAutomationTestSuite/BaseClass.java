package org.WorkforceAutomationTestSuite;

import java.net.MalformedURLException;
import java.net.URL;

import io.qameta.allure.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

@SuppressWarnings("deprecation")
public class BaseClass {

    static AndroidDriver<MobileElement> driver;
    // static AndroidDriver<MobileElement> driver1;

    @BeforeTest

    @Epic("Manpower Management")
    @Feature("Login")
    @Story("As a user, I should be able to log in with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Valid login test")
    public static void setup() throws MalformedURLException, InterruptedException {

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, 13);
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        // dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\bhavnesh.sharma\\Desktop\\VmsApp\\\\app-release9.apk");

        dc.setCapability("appPackage", "jbm.thirdeye.payscale");
        dc.setCapability("appActivity", "jbm.thirdeye.payscale.MainActivity");
        @SuppressWarnings("deprecation")
        URL url = new URL("http://0.0.0:4723/wd/hub");

        driver = new AndroidDriver<MobileElement>(url, dc);

        Thread.sleep(5000);

        MobileElement flutterButton = (MobileElement) driver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]");
        flutterButton.click();
        Thread.sleep(50);

        MobileElement textBox = (MobileElement) driver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]");
        textBox.sendKeys("shashwat.gupta@jbmgroup.com");

        MobileElement flutterButton1 = (MobileElement) driver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]");
        flutterButton1.click();

        MobileElement textBox1 = (MobileElement) driver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]");
        textBox1.sendKeys("123456");

        driver.pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);

        MobileElement flutterButton2 = (MobileElement) driver
                .findElementByXPath("//android.widget.Button[@content-desc=\"Sign In\"]");
        flutterButton2.click();
    }

    public static void scrollToElementByAccessibilityId(AndroidDriver<MobileElement> driver, String accessibilityId) {
        // Scroll down to the element with the specified accessibility id
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().descriptionContains(\""
                        + accessibilityId + "\"))"));

    }

    public static void swipeHorizontal(AppiumDriver driver, int startX, int endX, int y) {
        Dimension size = driver.manage().window().getSize();
        int startY = size.height / 2;

        new TouchAction(driver).press(PointOption.point(startX, y)).waitAction().moveTo(PointOption.point(endX, y))
                .release().perform();
    }

    @Test
    public void wfaAppLaunched() throws InterruptedException {
        System.out.println("WFA app launched successfully");

    }

    @AfterSuite
    public void teardowm() {
        // driver.close();
        // driver.quit();
    }
}
