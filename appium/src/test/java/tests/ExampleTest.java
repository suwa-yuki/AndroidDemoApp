package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    private final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
    private final int TIMEOUT = 30;
    public static AndroidDriver mDriver;

    @Before
    public void setUp() throws Exception {
        URL url = new URL(URL_STRING);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "jp.classmethod.sample.demoapp");
        capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "jp.classmethod.sample.demoapp.MainActivity");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("resetKeyboard", true);
        mDriver = new AndroidDriver(new URL(URL_STRING), capabilities);
        mDriver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        if (mDriver != null) {
            mDriver.quit();
        }
    }

    @Test
    public void Example() throws Exception {
        mDriver.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.view.View[1]/android.widget.ImageButton[1]").click();
        String message = mDriver.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.view.View[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]").getText();
        Assert.assertEquals("Replace with your own action", message);
    }

}
