import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Function;

public class AppiumTests {

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;

    //Elements
    String secondNewJob = "//android.widget.FrameLayout[2]/android.widget.LinearLayout/" +
            "android.widget.RelativeLayout/android.widget.ImageView";

    @Before
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability("deviceName", "Galaxy Nexus API 24");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("appPackage", "com.mercadopago.example");
        caps.setCapability("appActivity","com.mercadopago.CheckoutExampleActivity");
        caps.setCapability("noReset","false");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
    }


    @Test
    public void basicTest() {
        //Click button
        driver.findElementById("customInitializeButton").click();
    }

    @After
    public void teardown() {
        //driver.quit();
    }
}