package pro.learnup.pageobject.pages.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pro.learnup.pageobject.pages.BaseView;
import pro.learnup.pageobject.pages.CartPage;
import pro.learnup.pageobject.pages.PhonesPage;
import pro.learnup.pageobject.pages.elements.Button;

public class HeaderBlock extends BaseView {


    @FindBy(xpath = "//input[contains(@id, 'Username')]")
    private WebElement userNameInput;
    @FindBy(xpath = "//input[contains(@id, 'Password')]")
    private WebElement passwordInput;
    @FindBy(xpath = "//a[.='CART']")
    private WebElement cartButton;

    private final By loginButton = By.xpath("//button[.='LOGIN']"); //можно и так, тогда ленивая инициализация не нужна

    public HeaderBlock(WebDriver webDriver) {
        super(webDriver);
    }

    public PhonesPage login(String login, String password) {
        webDriver.findElement(loginButton).click();
        userNameInput.sendKeys(login);
        passwordInput.sendKeys(password);
        new Button(webDriver, "Submit").click();
        new WebDriverWait(webDriver, 1).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='LOGOUT']")));
        return new PhonesPage(webDriver);
    }


    public CartPage goToCart() {
        cartButton.click();
        return new CartPage(webDriver);
    }
}
