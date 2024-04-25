package am.aua.page.aboutmodal;

import org.openqa.selenium.By;

public class AboutModalLocators {
    static final By VERSION = By.xpath("//div[contains(@class, 'orangehrm-about')]//div[contains(@class, 'oxd-grid-item')]/p[contains(., 'OS')]");
    static final By CLOSE_BUTTON = By.className("oxd-dialog-close-button");
}
