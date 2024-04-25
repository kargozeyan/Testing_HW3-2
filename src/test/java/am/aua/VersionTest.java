package am.aua;

import am.aua.page.aboutmodal.AboutModal;
import am.aua.page.dashboard.DashboardPage;
import org.testng.annotations.Test;

import static am.aua.Constants.ADMIN_PASSWORD;
import static am.aua.Constants.ADMIN_USERNAME;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VersionTest extends BaseTest {
    @Test
    public void testDisplaysTheSameVersionInLoginPageAndAboutModal() {
        String versionOnLoginPage = loginPage.getVersion();
        assertThat(versionOnLoginPage)
                .isNotNull();

        loginPage.enterUsername(ADMIN_USERNAME);
        loginPage.enterPassword(ADMIN_PASSWORD);
        DashboardPage dashboardPage = loginPage.clickSubmit();

        AboutModal aboutModal = dashboardPage.getHeader().clickAbout();

        assertThat(aboutModal)
                .extracting(AboutModal::getVersion)
                .isEqualTo(versionOnLoginPage);
    }
}
