package am.aua;

import am.aua.page.aboutmodal.AboutModal;
import am.aua.page.buzz.BuzzPage;
import am.aua.page.dashboard.DashboardPage;
import am.aua.page.myinfo.MyInfoPage;
import org.testng.annotations.Test;

import static am.aua.Constants.ADMIN_PASSWORD;
import static am.aua.Constants.ADMIN_USERNAME;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MyInfoTest extends BaseTest {
    @Test
    public void testDisplaysTheSameNameInHeaderAndInfoPage() {
        loginPage.enterUsername(ADMIN_USERNAME);
        loginPage.enterPassword(ADMIN_PASSWORD);

        DashboardPage dashboardPage = loginPage.clickSubmit();

        AboutModal aboutModal = dashboardPage.getHeader().clickAbout();
        aboutModal.close();

        BuzzPage buzzPage = dashboardPage.getNavigationBar().clickBuzzPage();
        MyInfoPage myInfoPage = buzzPage.getNavigationBar().clickMyInfo();


        String userNameInHeader = myInfoPage.getHeader().getUserName();
        assertThat(userNameInHeader).isNotNull();
        assertThat(myInfoPage.getName())
                .isNotNull()
                .isEqualTo(userNameInHeader);
    }
}
