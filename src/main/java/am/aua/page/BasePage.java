package am.aua.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public abstract class BasePage {
    protected WebDriver driver;
    protected Wait<WebDriver> wait;

    public BasePage(WebDriver driver, Wait<WebDriver> wait) {
        this.driver = driver;
        this.wait = wait;
    }
}
