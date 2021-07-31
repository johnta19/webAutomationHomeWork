package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InfoPage {
    WebDriver driver;
    WebDriverWait wait;

    public InfoPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//nav/ul/li[1]/a")
    public WebElement questionsAnswers;

    @FindBy(xpath = "//nav/ul/li[2]/a")
    public WebElement credit;

    @FindBy(xpath = "//nav/ul/li[3]/a")
    public WebElement deliveryPayment;

    @FindBy(xpath = "//nav/ul/li[7]/a")
    public WebElement cooperation;

    @FindBy(xpath = "//nav/ul/li[8]/a")
    public WebElement vacancies;

    public void clickQuestionAnswer() {
        wait.until(ExpectedConditions.elementToBeClickable(questionsAnswers));
        questionsAnswers.click();
        driver.navigate().back();
    }

    public void clickCredit() {
        wait.until(ExpectedConditions.elementToBeClickable(credit));
        credit.click();
        driver.navigate().back();
    }

    public void clickDeliveryPayment() {
        wait.until(ExpectedConditions.elementToBeClickable(deliveryPayment));
        deliveryPayment.click();
        driver.navigate().back();
    }

    public void clickCooperation() {
        wait.until(ExpectedConditions.elementToBeClickable(cooperation));
        cooperation.click();
    }

    public void clickVacancies() {
        wait.until(ExpectedConditions.elementToBeClickable(vacancies));
        vacancies.click();
    }
}
