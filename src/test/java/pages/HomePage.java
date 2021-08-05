package pages;

import CustomWait.*;
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

    private String url = "https://rozetka.com.ua/";
    private String homeTitle = "Интернет-магазин ROZETKA™: официальный сайт самого популярного онлайн-гипермаркета в Украине";

    @FindBy(xpath = "//sidebar-fat-menu/div/ul/li[2]/a")
    private WebElement phonesCategory;

    @FindBy(className = "search-form__input")
    private WebElement searchField;

    @FindBy(xpath = "//a[@href=\"https://rozetka.com.ua/contacts/\"]")
    private WebElement contactsButton;

    @FindBy(xpath = "//rz-cart[@class=\"header-actions__component\"]")
    private WebElement cartButton;

    @FindBy(className = "header__logo")
    private WebElement indexPage;

    private By titleLocator = By.xpath("//sidebar-fat-menu/div/ul");

    private By resultLocator = By.xpath("(//li[2]/a)[4]");

    public void clickPhoneCategoryCustomWait() {
        WebElement titleLink = wait.until(new ResultField(resultLocator, titleLocator));
        titleLink.click();
    }

    public void checkUrl() {
        if (!wait.until(new PageLoaded(homeTitle, url))) {
            throw new RuntimeException("home page is not displayed");
        }
    }

    public void clickPhoneCategory() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//sidebar-fat-menu/div/ul/li[2]/a")));
        phonesCategory.click();
    }

    public void clickSearchField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("search-form__input")));
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
