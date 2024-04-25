package am.aua.page;

import am.aua.page.header.Header;
import am.aua.page.navigationbar.NavigationBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public abstract class NavigablePage extends BasePage {
    private final Header header;
    private final NavigationBar navigationBar;

    public NavigablePage(WebDriver driver, Wait<WebDriver> wait) {
        super(driver, wait);

        this.header = new Header(driver, wait);
        this.navigationBar = new NavigationBar(driver, wait);
    }

    public Header getHeader() {
        return header;
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }
}
