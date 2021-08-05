package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public ProductPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        this.driver = driver;
        this.wait = wait;
        this.actions = actions;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//app-product-buy-btn/app-buy-button/button")
    private WebElement buyButton;

    public void clickBuyButton() {
        actions.moveToElement(buyButton).build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//app-product-buy-btn/app-buy-button/button")));
        buyButton.click();
    }
}
