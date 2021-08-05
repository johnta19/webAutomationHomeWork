package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.modal__header > button")
    private WebElement modalWindow;

    @FindBy(xpath = "//single-modal-window/div[2]/div[2]")
    private WebElement checkCart;

    @FindBy(id = "cartProductActions0")
    private WebElement contextMenuAtCart;

    @FindBy(css = "#cartProductActions0 > li:nth-child(1) > rz-trash-icon > button")
    private WebElement deleteFromCart;

    public boolean cartIsEmpty() {
        return getTextFromCart().contains("Корзина пуста");
    }

    public void closeCartPage() {
        wait.until(ExpectedConditions.elementToBeClickable(modalWindow));
        modalWindow.click();
    }

    public void checkCart() {
        wait.until(ExpectedConditions.elementToBeClickable(checkCart));
    }

    public String getTextFromCart() {
       return checkCart.getText();
    }

    public void clickContextMenuAtCart() {
        wait.until(ExpectedConditions.elementToBeClickable(contextMenuAtCart));
        contextMenuAtCart.click();
    }

    public void deleteProductFromCart() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteFromCart));
        deleteFromCart.click();
    }
}
