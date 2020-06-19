import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pageobject.CartPage;
import pageobject.CheckoutPage;
import pageobject.ConfirmationPage;
import pageobject.HomePage;

import java.net.MalformedURLException;
import java.net.URL;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber-json-report.json"},
        strict = true
        //tags = {"@sayma"}//
)
public class TestRunner
{
    public static final String USERNAME = "saymanasrin1";
    public static final String AUTOMATE_KEY = "wvjdcxxLkzxfz9X9pqxz";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    static WebDriver driver;
    public static HomePage homePage;
    public static CartPage cartPage;
    public static CheckoutPage checkoutPage;
    public static ConfirmationPage confirmationPage;
    @BeforeClass
    public static void startBrowser() throws InterruptedException{

   //   WebDriverManager.chromedriver().setup();

   //   driver = new ChromeDriver();


       DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "83.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("name", "Bstack-[Java] Sample Test");

        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Thread.sleep(10000);


    }
    @AfterClass
    public static void stopBrowser()
    {
        driver.quit();
    }


}