package Automation;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Calculator_Emulator {
    public AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", "emulator-5556");
        capabilities.setCapability("appium:appPackage", "com.android.calculator2");
        capabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
        capabilities.setCapability("appium:platformVersion", "9.0");
        capabilities.setCapability("platformName", "Android");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        System.out.println("Start Automation..............");
    }

    @Test
    public void testAddCalculator1() {
        WebElement two = driver.findElement(By.id("digit_2"));
        two.click();
        WebElement plus = driver.findElement(By.id("op_add"));
        plus.click();
        WebElement four = driver.findElement(By.id("digit_4"));
        four.click();
        WebElement equalTo = driver.findElement(By.id("eq"));
        equalTo.click();
        WebElement results = driver.findElement(By.id("result"));
        String actualResult = results.getText();
        System.out.println("Actual Result: " + actualResult);

        // Verify the result
        Assert.assertEquals(actualResult, "6", "Calculation result is incorrect!");
    }
    @Test
    public void testAddCalculator2() {
        WebElement two = driver.findElement(By.id("digit_2"));
        WebElement four = driver.findElement(By.id("digit_4"));
        WebElement plus = driver.findElement(By.id("op_add"));
        WebElement equalTo = driver.findElement(By.id("eq"));
        two.click();
        two.click();
        plus.click();
        four.click();
        four.click();
        equalTo.click();
        WebElement results = driver.findElement(By.id("result"));
        String actualResult = results.getText();
        System.out.println("Actual Result: " + actualResult);

        // Verify the result
        Assert.assertEquals(actualResult, "66", "Calculation result is incorrect!");
    }

    @Test
    public void testSubCalculator() {
        WebElement two = driver.findElement(By.id("digit_4"));
        two.click();
        WebElement plus = driver.findElement(By.id("op_sub"));
        plus.click();
        WebElement four = driver.findElement(By.id("digit_2"));
        four.click();
        WebElement equalTo = driver.findElement(By.id("eq"));
        equalTo.click();
        WebElement results = driver.findElement(By.id("result"));
        String actualResult = results.getText();
        System.out.println("Actual Result: " + actualResult);

        // Verify the result
        Assert.assertEquals(actualResult, "2", "Calculation result is incorrect!");
    }
    @Test
    public void testAddCalculator3() {
        WebElement two = driver.findElement(By.id("digit_2"));
        WebElement four = driver.findElement(By.id("digit_4"));
        WebElement plus = driver.findElement(By.id("op_add"));
        WebElement equalTo = driver.findElement(By.id("eq"));
        WebElement results = driver.findElement(By.id("result"));

        // Initialize TouchAction
        TouchAction action = new TouchAction(driver);

        // Tap 2, two times (to simulate 22)
        action.tap(ElementOption.element(two)).perform();
        action.tap(ElementOption.element(two)).perform();

        // Tap '+' button
        action.tap(ElementOption.element(plus)).perform();

        // Tap 4, two times (to simulate 44)
        action.tap(ElementOption.element(four)).perform();
        action.tap(ElementOption.element(four)).perform();

        // Tap '=' button
        action.tap(ElementOption.element(equalTo)).perform();

        // Get the result text
        String actualResult = results.getText();
        System.out.println("Actual Result: " + actualResult);

        // Verify the result
        Assert.assertEquals(actualResult, "66", "Calculation result is incorrect!");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
