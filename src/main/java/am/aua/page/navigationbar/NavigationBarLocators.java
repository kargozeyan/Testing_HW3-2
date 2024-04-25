package am.aua.page.navigationbar;

import org.openqa.selenium.By;

class NavigationBarLocators {

    static final By MY_INFO_ITEM = navigationItem("My Info");
    static final By BUZZ_ITEM = navigationItem("Buzz");

    private static By navigationItem(String name) {
        return By.xpath("//span[contains(@class, 'oxd-main-menu-item--name')][text()='%s']".formatted(name));
    }
}