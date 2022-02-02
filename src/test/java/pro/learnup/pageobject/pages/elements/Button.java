package pro.learnup.pageobject.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;

public class Button implements WrapsElement {
    private WebElement webElement;

    public Button(WebDriver webDriver, String name) {
        this.webElement = webDriver.findElement(By.xpath("//button[.='" + name + "']"));
    }

    @Override
    public WebElement getWrappedElement() {
        return this.webElement;
    }

    public Button click() {
        getWrappedElement().click();
        return this;
    }

}
