package am.aua.page.dashboard;

import am.aua.page.BasePage;
import am.aua.page.NavigablePage;
import am.aua.page.header.Header;
import am.aua.page.navigationbar.NavigationBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class DashboardPage extends NavigablePage {

    public DashboardPage(WebDriver driver, Wait<WebDriver> wait) {
        super(driver, wait);
    }
}
