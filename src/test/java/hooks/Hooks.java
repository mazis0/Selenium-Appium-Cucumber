package hooks;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Hooks {
    public static AndroidDriver<AndroidElement> driver;

    private final DesiredCapabilities caps = new DesiredCapabilities();

    private Scenario scenario;

    public Hooks() throws IOException {
    }


    @Before
    public void setupDeviceCapabilities() throws IOException, URISyntaxException {

        caps.setCapability("deviceName", "Samsung");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "14");
        caps.setCapability("udid","RRCT4006SYD");
        caps.setCapability("appPackage", "com.lionparcel.services.consumer");
        caps.setCapability("appActivity", "com.lionparcel.services.consumer.view.main.MainActivity");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("autoGrantPermissions",true);
        caps.setCapability("noReset", true);

        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
    }

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @After(order = 0)
    public void stopAndroidDriver() throws InterruptedException{
        driver.closeApp();
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);

        }
    }

}
