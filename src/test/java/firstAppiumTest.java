import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

public class firstAppiumTest {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName","UIAutomator2");
        cap.setCapability("platformName","Android");
        cap.setCapability("deviceName","Pixel_3a_API_30_x86");
        cap.setCapability("appActivity","io.appium.android.apis.ApiDemos");
        cap.setCapability("appPackage","io.appium.android.apis");
        cap.setCapability("app","C:\\Users\\deepak\\Downloads\\ApiDemos-debug.apk");
        //AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        //driver.findElement(By.xpath("//*[@text='Views']")).click();
        AppiumDriver<RemoteWebElement> driver2= new AndroidDriver<RemoteWebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        //driver2.startActivity(new Activity("com.example", "ActivityName"));
        //((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)", "");
        //TouchActions action = new TouchActions(driver);
        //action.scroll(driver.findElement(By.xpath("//*[@text='WebView']")), 10, 100);
        //action.perform();
        Thread.sleep(5000);
//        driver.findElement(By.xpath("//*[@text='WebView']")).click();
//        Set<String> views = driver.getContextHandles();
//        System.out.println(views);
//        driver.context("WEBVIEW_io.appium.android.apis");
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getPageSource());
        driver2.context("NATIVE_APP");
        //connection(driver2);
       // setLocation(driver2);
       // pressByElement(driver2);
        //activity(driver2);
        //dragNDrop(driver2);
        openNotification(driver2);
        pressHomeKey(driver2);
    }

        public static void pressByElement(AppiumDriver<RemoteWebElement> driver) throws InterruptedException {
        driver.findElement(By.xpath("//*[@text='Views']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@text='Buttons']")).click();
        new TouchAction(driver)
                .press(element(driver.findElement(By.id("io.appium.android.apis:id/button_toggle"))))
                .waitAction(waitOptions(ofSeconds(5)))
                .release().perform();
         }

        public static void pressByElementPoint(AppiumDriver<RemoteWebElement> driver) {
        driver.findElement(By.xpath("//*[@text='Views']")).click();
        driver.findElement(By.xpath("//*[@text='Buttons']")).click();
        Point point = driver.findElement(By.id("io.appium.android.apis:id/button_toggle")).getLocation();
        new TouchAction(driver)
                .press(point(point.x , point.y))
                .waitAction(waitOptions(ofSeconds(1)))
                .release()
                .perform();
    }

    public static void dragNDrop(AppiumDriver<RemoteWebElement> driver) throws InterruptedException {
        driver.findElement(By.xpath("//*[@text='Views']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@text='Drag and Drop']")).click();
        RemoteWebElement dragDot1 = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        RemoteWebElement dragDot3 = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_3"));
        TouchAction dragNDrop = new TouchAction(driver)
                .longPress(element(dragDot1))
                .moveTo(element(dragDot3))
                .release();
        dragNDrop.perform();
    }

    public static void activity(AppiumDriver<RemoteWebElement> driver) throws InterruptedException {
        Activity activity = new Activity("io.appium.android.apis",
                ".accessibility.AccessibilityNodeProviderActivity");
        Thread.sleep(2000);
        ((AndroidDriver<RemoteWebElement>)driver).startActivity(activity);
        Thread.sleep(2000);
        Activity activity2 = new Activity("io.appium.android.apis",
                "io.appium.android.apis.ApiDemos");
        ((AndroidDriver<RemoteWebElement>)driver).startActivity(activity2);
    }

    public static void connection(AppiumDriver<RemoteWebElement> driver) {
        //ConnectionState state = ((AndroidDriver<RemoteWebElement>)driver).setConnection(new ConnectionStateBuilder()
        //         .withAirplaneModeDisabled().withDataEnabled().withAirplaneModeDisabled()
        //       .build());
        //System.out.println(state.isAirplaneModeEnabled());
        //System.out.println(state.isWiFiEnabled());
        //System.out.println(state.isDataEnabled());
        ((AndroidDriver<RemoteWebElement>)driver).toggleAirplaneMode();
        ((AndroidDriver<RemoteWebElement>)driver).toggleData();
        ((AndroidDriver<RemoteWebElement>)driver).toggleAirplaneMode();
        ((AndroidDriver<RemoteWebElement>)driver).toggleData();
        ((AndroidDriver<RemoteWebElement>)driver).toggleData();
    }

    public static void setLocation(AppiumDriver<RemoteWebElement> driver){
        Location location=new Location(12.97, 77.59, 34);
        driver.setLocation(location);
    }

    public static void openNotification(AppiumDriver<RemoteWebElement> driver){
        ((AndroidDriver<RemoteWebElement>)driver).openNotifications();
    }

    public static void pressHomeKey(AppiumDriver<RemoteWebElement> driver){
        ((AndroidDriver<RemoteWebElement>)driver).pressKey(new KeyEvent(AndroidKey.HOME));
    }
}
