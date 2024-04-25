package am.aua.page.navigationbar;

import am.aua.page.BasePage;
import am.aua.page.buzz.BuzzPage;
import am.aua.page.myinfo.MyInfoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import static am.aua.page.navigationbar.NavigationBarLocators.BUZZ_ITEM;
import static am.aua.page.navigationbar.NavigationBarLocators.MY_INFO_ITEM;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class NavigationBar extends BasePage {

    public NavigationBar(WebDriver driver, Wait<WebDriver> wait) {
        super(driver, wait);

        wait.until(visibilityOfElementLocated(MY_INFO_ITEM));
    }

    public MyInfoPage clickMyInfo() {
        driver.findElement(MY_INFO_ITEM).click();
        return new MyInfoPage(driver, wait);
    }

    public BuzzPage clickBuzzPage() {
        driver.findElement(BUZZ_ITEM).click();
        return new BuzzPage(driver, wait);
    }
}
