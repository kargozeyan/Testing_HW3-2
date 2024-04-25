package am.aua.page.header;

import org.openqa.selenium.By;

class HeaderLocators {
    static final By TITLE = By.xpath("//div[contains(@class, 'oxd-topbar-header-title')]//h6[contains(@class, 'oxd-text')]");
    static final By USER_DROPDOWN = By.className("oxd-userdropdown");
    static final By USER_NAME = By.className("oxd-userdropdown-name");
    static final By LOGOUT_ITEM = userDropDownItem("Logout");
    static final By ABOUT_ITEM = userDropDownItem("About");

    private static By userDropDownItem(String name) {
        return By.xpath("//ul[@class='oxd-dropdown-menu']//a[text()='%s']".formatted(name));
    }
}
