package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage
{
    WebDriver driver;
    public CheckoutPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//input[@value='Continue'])[1]")
    public WebElement continueButton1;

    @FindBy(xpath = "(//input[@value='Continue'])[3]")
    public WebElement continueButton3;

    @FindBy(xpath = "//input[@value='Confirm']")
    public WebElement confirmButton;

    public void clickContinue(){
        continueButton1.click();
    }
    public void clickContinue3(){
        continueButton3.click();
    }
    public void clickConfirm(){
        confirmButton.click();
    }

}
