package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

// here store web elements and make reusable methods for testng
public class Page extends BasePage{
    @FindBy(xpath = "//button[contains(@class,'cookie')]")
    private WebElement AcceptCookieAndClose;
    @FindBy(xpath = "//a[@data-id='HP']")
    private WebElement hpCheckBoxClick;
    @FindBy(xpath = "//option[contains(text(),\"От дорогих\")]")
    private WebElement expensiveSort;
    @FindBy(xpath = "//rz-catalog//div[@data-goods-id='339200809']")
    private WebElement firstElementOfQuery;
    @FindBy(xpath = "//span[text()=' Купить ']/ancestor::button[@aria-label='Купить']/ancestor::li")
    private WebElement buyButton;
    @FindBy(xpath = "//div[@class='cart-receipt__sum-price']/span")
    private WebElement totalCartSum;
    @FindBy(xpath = "//span[text()=' В корзине ']")
    private WebElement BasketButton;
    public Page(WebDriver driver) {
        super(driver);
    }

    public void hpCHeckBoxClick(){
        waitForPageLoading(20);
        waitVisibilityOfElement(30,By.xpath("//a[@data-id='HP']"));
        hpCheckBoxClick.click();
    }
    public void expensiveSortClick(){
        waitForPageLoading(30);
       expensiveSort.click();
    }

    public void firstElementClick() throws InterruptedException {
        waitForPageLoading(20);
        waitVisibilityOfElement(60,By.xpath("//rz-catalog//div[@data-goods-id='339200809']"));
        firstElementOfQuery.click();
    }

    public void buyClick(){
        waitForPageLoading(30);
        waitVisibilityOfElement(60,By.xpath("//span[text()=' Купить ']/ancestor::button[@aria-label='Купить']/ancestor::li"));
        Actions ac = new Actions(driverFather);
        ac.moveToElement(driverFather.findElement(By.xpath("//span[text()=' Купить ']/ancestor::button[@aria-label='Купить']/ancestor::li"))).build().perform();
        buyButton.click();
    }

    public void buyBasketClick(){
        BasketButton.click();
    }

    public String checkSumOfGoods(){
        waitVisibilityOfElement(60,By.xpath("//div[@class='cart-receipt__sum-price']/span"));
       return totalCartSum.getText();
    }
}
