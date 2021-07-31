package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectProductPage {
    WebDriver driver;
    WebDriverWait wait;

    public SelectProductPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(text(),'Apple iPhone 11 64GB Black Slim Box (MHDA3)')]")
    public WebElement someIphone;

    @FindBy(partialLinkText = "HP Envy Laptop 15-ep0016ur (1U9J8EA) Silver")
    public WebElement someHpNotebook;

    public void chooseSomePhone() {
        someIphone.click();
    }

    public void chooseSomeNoteBook() {
        someHpNotebook.click();
    }
}
