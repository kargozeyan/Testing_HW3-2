package am.aua;

import am.aua.page.dashboard.DashboardPage;
import am.aua.page.header.Header;
import am.aua.page.login.LoginPage;
import org.testng.annotations.Test;

import static am.aua.Constants.ADMIN_PASSWORD;
import static am.aua.Constants.ADMIN_USERNAME;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AuthTest extends BaseTest {

    @Test
    public void testLogin() {
        loginPage.enterUsername(ADMIN_USERNAME);
        loginPage.enterPassword(ADMIN_PASSWORD);

        DashboardPage dashboardPage = loginPage.clickSubmit();

        assertThat(dashboardPage)
                .isNotNull().extracting(DashboardPage::getHeader)
                .isNotNull().extracting(Header::getPageTitle)
                .isEqualTo("Dashboard");
    }

    @Test
    public void testLogout() {
        loginPage.enterUsername(ADMIN_USERNAME);
        loginPage.enterPassword(ADMIN_PASSWORD);

        DashboardPage dashboardPage = loginPage.clickSubmit();
        LoginPage newLoginPage = dashboardPage.getHeader().clickLogout();
        assertThat(newLoginPage)
                .isNotNull()
                .extracting(LoginPage::getTitle)
                .isEqualTo("Login");
    }
}
