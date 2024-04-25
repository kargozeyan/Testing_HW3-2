package am.aua.page.buzz;

import am.aua.page.NavigablePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import static am.aua.page.buzz.BuzzPageLocators.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BuzzPage extends NavigablePage {
    public BuzzPage(WebDriver driver, Wait<WebDriver> wait) {
        super(driver, wait);

        wait.until(visibilityOfElementLocated(POST_INPUT));
    }

    public void inputPostText(String text) {
        driver.findElement(POST_INPUT).sendKeys(text);
    }

    public void submitPost() {
        driver.findElement(SUBMIT_BUTTON).click();
        wait.until(visibilityOfElementLocated(POST_BODY));
    }

    public String getLatestPost() {
        return driver.findElement(POST_BODY).getText();
    }
}
