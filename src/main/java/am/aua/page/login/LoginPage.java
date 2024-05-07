package am.aua.page.login;

import am.aua.page.BasePOM;
import am.aua.page.dashboard.DashboardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import static am.aua.page.login.LoginPageLocators.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class LoginPage extends BasePOM {

    public LoginPage(WebDriver driver, Wait<WebDriver> wait) {
        super(driver, wait);

        wait.until(visibilityOfElementLocated(INPUT_USERNAME));
    }

    public void enterUsername(String username) {
        driver.findElement(INPUT_USERNAME).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(INPUT_PASSWORD).sendKeys(password);
    }

    public DashboardPage clickSubmit() {
        driver.findElement(BUTTON_SUBMIT).click();
        return new DashboardPage(driver, wait);
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public String getVersion() {
        return driver.findElement(VERSION).getText();
    }
}
