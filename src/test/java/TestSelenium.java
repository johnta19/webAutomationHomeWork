import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.*;
import java.util.concurrent.TimeUnit;

public class TestSelenium {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private HomePage homePage;
    private SelectSubcategoryPage selectSubcategoryPage;
    private SelectProductPage selectProductPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private InfoPage infoPage;
    private String url = "https://rozetka.com.ua/";

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        actions = new Actions(driver);
        homePage = new HomePage(driver, wait);
        selectSubcategoryPage = new SelectSubcategoryPage(driver, wait);
        selectProductPage = new SelectProductPage(driver, wait);
        productPage = new ProductPage(driver, wait, actions);
        cartPage = new CartPage(driver, wait);
        infoPage = new InfoPage(driver, wait);
    }

    @BeforeTest
    public void profileSetup() {
        driver.manage().window().maximize();
    }

    @BeforeClass
    public void beforeTest() {
        driver.get(url);
    }

    @AfterClass
    public void afterTest() {
        driver.quit();
    }

    @Test(priority = 1)
    public void addIphoneToCart() {
        homePage.goToIndexPage();
        homePage.clickPhoneCategory();
        selectSubcategoryPage.clickAppleCategory();
        selectProductPage.chooseSomePhone();
        productPage.clickBuyButton();
        cartPage.closeCartPage();
    }

    @Test(priority = 2)
    public void checkCart() {
        homePage.clickCartButton();
        cartPage.checkCart();
        if(cartPage.cartIsEmpty()) {
            cartPage.closeCartPage();
        }
        else {
            cartPage.clickContextMenuAtCart();
            cartPage.deleteProductFromCart();
            cartPage.closeCartPage();
        }
    }


    @Test(priority = 3)
    public void addHpNotebookToCart() {
        homePage.clickSearchField();
        homePage.inputSearchField("hp envy");
        selectProductPage.chooseSomeNoteBook();
        productPage.clickBuyButton();
        cartPage.closeCartPage();
        checkCart();
    }

    @Test()
    public void checkInfo() {
        homePage.clickContactsButton();
        infoPage.clickQuestionAnswer();
        infoPage.clickCredit();
        infoPage.clickDeliveryPayment();
        infoPage.clickCooperation();
        infoPage.clickVacancies();
    }

}