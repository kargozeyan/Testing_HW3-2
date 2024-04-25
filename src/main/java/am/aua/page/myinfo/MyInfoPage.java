package am.aua.page.myinfo;

import am.aua.page.NavigablePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import static am.aua.page.myinfo.MyInfoLocators.NAME;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class MyInfoPage extends NavigablePage {

    public MyInfoPage(WebDriver driver, Wait<WebDriver> wait) {
        super(driver, wait);

        wait.until(visibilityOfElementLocated(NAME));
        wait.until(not(textToBe(NAME, "")));
    }

    public String getName() {
        return driver.findElement(NAME).getText();
    }
}
