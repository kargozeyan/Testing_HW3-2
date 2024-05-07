package am.aua.page.header;

import am.aua.page.BasePOM;
import am.aua.page.aboutmodal.AboutModal;
import am.aua.page.login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import static am.aua.page.header.HeaderLocators.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Header extends BasePOM {

    public Header(WebDriver driver, Wait<WebDriver> wait) {
        super(driver, wait);

        wait.until(visibilityOfElementLocated(TITLE));
    }

    public String getPageTitle() {
        return driver.findElement(TITLE).getText();
    }

    public String getUserName() {
        return driver.findElement(USER_NAME).getText();
    }

    public LoginPage clickLogout() {
        driver.findElement(USER_DROPDOWN).click();
        wait.until(visibilityOfElementLocated(LOGOUT_ITEM));
        driver.findElement(LOGOUT_ITEM).click();

        return new LoginPage(driver, wait);
    }

    public AboutModal clickAbout() {
        driver.findElement(USER_DROPDOWN).click();
        wait.until(visibilityOfElementLocated(ABOUT_ITEM));
        driver.findElement(ABOUT_ITEM).click();

        return new AboutModal(driver, wait);
    }
}
