package pro.learnup.pageobject;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pro.learnup.pageobject.pages.PhonesPage;
import pro.learnup.selenium.BaseTest;

public class ShopTest extends BaseTest {
    String login = "admin";
    String password = "admin";

    @ParameterizedTest
    @ValueSource(strings = {"HTC U11"})
    public void buyPhoneTest(String phoneName) {
        webDriver.get("http://localhost:3000/");

        new PhonesPage(webDriver)
                .getHeaderBlock()
                .login(login, password)
                .selectPhone(phoneName)
                .checkPhoneName(phoneName)
                .clickAddToCart()
                .getHeaderBlock()
                .goToCart()
                .checkCartContainExactly(phoneName)
                .clickCheckOut()
                .clickConfirm()
                .checkThatCheckOutIsSuccessful();
    }
}
