package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//sidebar-fat-menu/div/ul/li[2]/a")
    public WebElement phonesCategory;

    @FindBy(className = "search-form__input")
    public WebElement searchField;

    @FindBy(xpath = "//a[@href=\"https://rozetka.com.ua/contacts/\"]")
    public WebElement contactsButton;

    @FindBy(xpath = "//rz-cart[@class=\"header-actions__component\"]")
    public WebElement cartButton;

    @FindBy(className = "header__logo")
    public WebElement indexPage;

    public void clickPhoneCategory() {
        phonesCategory.click();
    }

    public void clickSearchField() {
        wait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.click();
    }

    public void inputSearchField(String input) {
        wait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.sendKeys(input, Keys.ENTER);
    }

    public void clickContactsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(contactsButton));
        contactsButton.click();
    }

    public void clickCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();
    }

    public void goToIndexPage() {
        wait.until(ExpectedConditions.elementToBeClickable(indexPage));
        indexPage.click();
    }

}
