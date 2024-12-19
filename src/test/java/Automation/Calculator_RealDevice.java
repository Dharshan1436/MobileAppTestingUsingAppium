package Automation;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Calculator_RealDevice {
    public AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", "redmi 9i");
        capabilities.setCapability("appium:udid", "TGOR49Y5VC9XH6JF");
        capabilities.setCapability("appium:appPackage", "com.miui.calculator");
        capabilities.setCapability("appium:appActivity", ".cal.CalculatorActivity");
        capabilities.setCapability("appium:platformVersion", "11");
        capabilities.setCapability("platformName", "Android");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        System.out.println("Start Automation..............");

    }

    @Test
    public void testAddCalculator1() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement two = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_2_s")));
        two.click();
        WebElement plus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_plus_s")));
        plus.click();
        WebElement four = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_4_s")));
        four.click();
        WebElement equalTo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_equal_s")));
        equalTo.click();
        WebElement results = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        String actualResult = results.getText();
        System.out.println("Actual Result: " + actualResult);
        Thread.sleep(2000);
        // Verify the result
        Assert.assertEquals(actualResult, "= 6");
    }

    @Test
    public void testAddCalculator() throws InterruptedException {
        Thread.sleep(5000);
        WebElement two = driver.findElement(By.id("btn_2_s"));
        two.click();
        WebElement plus = driver.findElement(By.id("btn_plus_s"));
        plus.click();
        WebElement four = driver.findElement(By.id("btn_4_s"));
        four.click();
        WebElement equalTo = driver.findElement(By.id("btn_equal_s"));
        equalTo.click();
        WebElement results = driver.findElement(By.id("result"));
        String actualResult = results.getText();
        System.out.println("Actual Result: " + actualResult);

        // Verify the result
        Assert.assertEquals(actualResult, "= 6", "Calculation result is incorrect!");
    }
    @Test
    public void testSubCalculator() throws InterruptedException {
        Thread.sleep(5000);
        WebElement two = driver.findElement(By.id("btn_4_s"));
        two.click();
        WebElement sub = driver.findElement(By.id("btn_minus_s"));
        sub.click();
        WebElement four = driver.findElement(By.id("btn_2_s"));
        four.click();
        WebElement equalTo = driver.findElement(By.id("btn_equal_s"));
        equalTo.click();
        WebElement results = driver.findElement(By.id("result"));
        String actualResult = results.getText();
        System.out.println("Actual Result: " + actualResult);

        // Verify the result
        Assert.assertEquals(actualResult, "= 2", "Calculation result is incorrect!");
    }
    @Test
    public void testMulCalculator() throws InterruptedException {
        Thread.sleep(5000);
        WebElement two = driver.findElement(By.id("btn_2_s"));
        two.click();
        WebElement mul = driver.findElement(By.id("btn_mul_s"));
        mul.click();
        WebElement four = driver.findElement(By.id("btn_4_s"));
        four.click();
        WebElement equalTo = driver.findElement(By.id("btn_equal_s"));
        equalTo.click();
        WebElement results = driver.findElement(By.id("result"));
        String actualResult = results.getText();
        System.out.println("Actual Result: " + actualResult);

        // Verify the result
        Assert.assertEquals(actualResult, "= 8", "Calculation result is incorrect!");
    }
    @Test
    public void testDivCalculator() throws InterruptedException {
        Thread.sleep(5000);
        WebElement two = driver.findElement(By.id("btn_4_s"));
        two.click();
        WebElement div = driver.findElement(By.id("btn_div_s"));
        div.click();
        WebElement four = driver.findElement(By.id("btn_2_s"));
        four.click();
        WebElement equalTo = driver.findElement(By.id("btn_equal_s"));
        equalTo.click();
        WebElement results = driver.findElement(By.id("result"));
        String actualResult = results.getText();
        System.out.println("Actual Result: " + actualResult);

        // Verify the result
        Assert.assertEquals(actualResult, "= 2", "Calculation result is incorrect!");
    }
    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
