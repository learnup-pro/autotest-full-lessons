package pro.learnup.selenide.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import pro.learnup.selenide.pages.blocks.HeaderBlock;

public class BasePage {
    @Getter
    private HeaderBlock headerBlock = new HeaderBlock();
}
