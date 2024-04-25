package am.aua.page.aboutmodal;

import am.aua.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import static am.aua.page.aboutmodal.AboutModalLocators.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class AboutModal extends BasePage {

    public AboutModal(WebDriver driver, Wait<WebDriver> wait) {
        super(driver, wait);

        wait.until(visibilityOfElementLocated(VERSION));
    }

    public String getVersion() {
        return driver.findElement(VERSION).getText();
    }

    public void close() {
        driver.findElement(CLOSE_BUTTON).click();
    }
}
