import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pageobject.CartPage;
import pageobject.CheckoutPage;
import pageobject.ConfirmationPage;
import pageobject.HomePage;

import java.util.concurrent.TimeUnit;

public class MyStepdefs extends TestRunner
{


    @Before
    public void start()
    {
       // System.setProperty("webdriver.chrome.driver", "driver/chromedriver");//

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        confirmationPage = new ConfirmationPage(driver);

    }
    @After
    public void stop(Scenario scenario){
        byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshotBytes, "image/png");

    }

    @Given("I am in homepage url {string}")
    public void iAmInHomepageUrl(String url)
    {
        homePage.openUrl(url);
    }

    @When("I click on login link from navigation  bar")
    public void iClickOnLoginLinkFromNavigationBar()
    {
        homePage.clickLoginlink();
    }

    @And("I enter email {string}")
    public void iEnterEmailSaymaNasrinGmailCom(String email) {


        homePage.enterEmail(email);
    }


    @And("I enter password as {string}")
    public void iEnterPasswordAs(String password)
    {
        homePage.enterPassword(password);
    }

    @And("I click on login button")
    public void iClickOnLoginButton()
    {
        homePage.clickLogin();
    }

    @And("I click on add to cart")
    public void iClickOnAddToCart()
    {
        homePage.clickAddToCart();
    }

    @And("I go to cart")
    public void iGoToCart() throws InterruptedException {
        cartPage.navigateTocart();
        Thread.sleep(3000);
        driver.navigate().refresh();
    }

    @And("I enter Gift Card number")
    public void iEnterGiftCardNumber()
    {
        cartPage.enterGiftcard();
    }

    @And("I click on Add Gift Card")
    public void iClickOnAddGiftCard()
    {
        cartPage.clickAddGiftcard();
    }

    @And("I click on terms and condition")
    public void iClickOnTermsAndCondition()
    {
        cartPage.clickTermsofService();
    }

    @And("I click on checkout")
    public void iClickOnCheckout()
    {
        cartPage.clickCheckout();
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
        checkoutPage.clickContinue();
    }

    @And("I set default shipping method")
    public void iSetDefaultShippingMethod()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkoutPage.clickContinue3();
    }

    @And("I click on confirm")
    public void iClickOnConfirm()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkoutPage.clickConfirm();
    }

    @Then("The order confirmation screen is shown {string}")
    public void theOrderConfirmationScreenIsShown(String expectedText)
    {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualText = confirmationPage.getTitle();
        Assertions.assertEquals(expectedText,actualText);

    }



}
