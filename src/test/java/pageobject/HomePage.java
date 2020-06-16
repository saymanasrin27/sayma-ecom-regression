package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
    WebDriver driver;

    @FindBy(linkText="Log in")
    public WebElement loginLink;


    @FindBy(id="Email")
    public WebElement emailTextBox;

    @FindBy(id="Password")
    public WebElement passwordTextBox;

    @FindBy(css="input.login-button")
    public WebElement loginButton;

    @FindBy(xpath = "(//input[@value='Add to cart'])[3]")
    public  WebElement addToCartButton;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void clickLoginlink(){
        loginLink.click();

    }

    public void enterEmail(String email)
    {
        emailTextBox.sendKeys(email);
    }

    public void enterPassword(String pw)
    {
        passwordTextBox.sendKeys(pw);
    }

    public void clickLogin()
    {
        loginButton.click();
    }

    public void openUrl(String url)
    {
        driver.navigate().to(url);
    }

    public void clickAddToCart(){addToCartButton.click();}
}
