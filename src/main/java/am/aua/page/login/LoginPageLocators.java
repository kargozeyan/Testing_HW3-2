package am.aua.page.login;


import org.openqa.selenium.By;

class LoginPageLocators {
    static final By TITLE = By.className("orangehrm-login-title");
    static final By VERSION = By.xpath("//div[@class='orangehrm-copyright-wrapper']/p[1]");
    static final By INPUT_USERNAME = By.cssSelector("input[name='username']");
    static final By INPUT_PASSWORD = By.cssSelector("input[name='password']");
    static final By BUTTON_SUBMIT = By.cssSelector("button[type='submit']");
}
