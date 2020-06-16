package pageobject;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage
{
    WebDriver driver;
    public CartPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void navigateTocart()
    {
        driver.navigate().to("http://twentyconsulting-001-site1.dtempurl.com/cart");
    }

    @FindBy(id = "giftcardcouponcode")
    public WebElement giftcardTextBox;

    @FindBy(id = "applygiftcardcouponcode")
    public WebElement addGiftcardButton;

    @FindBy(id = "termsofservice")
    public WebElement termsButton;

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    public void enterGiftcard(){
        giftcardTextBox.sendKeys("241c8d86-8fc8");
    }

    public void clickAddGiftcard(){
        addGiftcardButton.click();
    }

    public void clickTermsofService(){
        termsButton.click();
    }

    public void clickCheckout(){
        checkoutButton.click();
    }


}
