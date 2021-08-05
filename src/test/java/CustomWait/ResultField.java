package CustomWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ResultField implements ExpectedCondition<WebElement> {

    By resultLocator;
    By parentLocator;

    public ResultField(By resultLocator, By parentLocator) {
        this.resultLocator = resultLocator;
        this.parentLocator = parentLocator;
    }

    @Override
    public WebElement apply(WebDriver driver) {
        WebElement parent = driver.findElement(parentLocator);
        WebElement result = parent.findElement(resultLocator);
        return (result.isDisplayed() ? result : null);
    }
}
