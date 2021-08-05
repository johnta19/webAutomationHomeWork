package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    private WebElement someIphone;

    @FindBy(partialLinkText = "HP Envy Laptop 15-ep0016ur (1U9J8EA) Silver")
    private WebElement someHpNotebook;
    private By BySomeHpNotebook = By.partialLinkText("HP Envy Laptop 15-ep0016ur (1U9J8EA) Silver");

    public void chooseSomePhone() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Apple iPhone 11 64GB Black Slim Box (MHDA3)')]")));
        someIphone.click();
    }

    public void chooseSomeNoteBook() {
        wait.until(ExpectedConditions.presenceOfElementLocated(BySomeHpNotebook));
        someHpNotebook.click();
    }
}
