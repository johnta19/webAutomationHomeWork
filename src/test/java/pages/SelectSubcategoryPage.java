package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectSubcategoryPage {
    WebDriver driver;
    WebDriverWait wait;

    public SelectSubcategoryPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='popular-category__title'][1]")
    public WebElement appleCategory;

    public void clickAppleCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(appleCategory));
        appleCategory.click();
    }
}
