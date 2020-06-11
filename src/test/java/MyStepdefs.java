import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class MyStepdefs extends TestRunner
{

    @Before
    public void start()
    {
       // System.setProperty("webdriver.chrome.driver", "driver/chromedriver");//

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @After
    public void stop(Scenario scenario){
        byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshotBytes, "image/png");

    }
    @Given("I am in homepage")
    public void iAmInHomepage()
    {
        driver.get("http://twentyconsulting-001-site1.dtempurl.com/");

    }

    @And("I click on login link from navigation  bar")
    public void iClickOnLoginLinkFromNavigationBar()
    {
        driver.findElement(By.linkText("Log in")).click();

    }

    @And("I enter user name as {string}")
    public void iEnterUserNameAs(String username)
    {
        driver.findElement(By.id("Email")).sendKeys("sayma.nasrin27@gmail.com");

    }

    @And("I enter password as {string}")
    public void iEnterPasswordAs(String password)
    {
        driver.findElement(By.xpath("//input[@name='Password']")) .sendKeys("Rony4143");
    }

    @And("I click on login button")
    public void iClickOnLoginButton()
    {
        driver.findElement(By.cssSelector("input.login-button")).click();
    }

    @And("I click on add to cart")
    public void iClickOnAddToCart()
    {
        driver.findElement(By.xpath("(//input[@value='Add to cart'])[3]")).click();
    }

    @And("I go to cart")
    public void iGoToCart() throws InterruptedException {
        driver.get("http://twentyconsulting-001-site1.dtempurl.com/cart");
        Thread.sleep(3000);
        driver.navigate().refresh();
    }

    @And("I enter Gift Card number")
    public void iEnterGiftCardNumber()
    {
        driver.findElement(By.id("giftcardcouponcode")).sendKeys("241c8d86-8fc8");
    }

    @And("I click on Add Gift Card")
    public void iClickOnAddGiftCard()
    {
        driver.findElement(By.id("applygiftcardcouponcode")).click();
    }

    @And("I click on terms and condition")
    public void iClickOnTermsAndCondition()
    {
        driver.findElement(By.id("termsofservice")).click();
    }

    @And("I click on checkout")
    public void iClickOnCheckout()
    {
        driver.findElement(By.id("checkout")).click();
    }

    /*@And("I click on ship to same address")
    public void iClickOnShipToSameAddress()
    {
        driver.findElement(By.id("ShipToSameAddress")).click();
    }

    @And("I select country")
    public void iSelectCountry()
    {
        Select country = new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
        country.selectByVisibleText("United Kingdom");

    }

    @And("I enter city")
    public void iEnterCity()
    {
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("London");
    }

    @And("I enter address")
    public void iEnterAddress()
    {
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("woodbridge road");
    }

    @And("I enter post code")
    public void iEnterPostCode()
    {
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("IG119ER");
    }

    @And("I enter phone number")
    public void iEnterPhoneNumber()
    {
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("07956013258");
    }*/

    @And("I click on continue")
    public void iClickOnContinue()
    {
        driver.findElement(By.xpath("(//input[@value='Continue'])[1]")).click();
    }

    @And("I set default shipping method")
    public void iSetDefaultShippingMethod()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("(//input[@value='Continue'])[3]")).click();
    }

    @And("I click on confirm")
    public void iClickOnConfirm()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//input[@value='Confirm']")).click();
    }

    @Then("The order confirmation screen is shown {string}")
    public void theOrderConfirmationScreenIsShown(String expectedText)
    {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualText = driver.findElement(By.xpath("//div[@class='title']/strong")).getText();
        Assertions.assertEquals(expectedText,actualText);
    }
}
