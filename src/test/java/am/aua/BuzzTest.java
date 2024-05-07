package am.aua;

import am.aua.page.aboutmodal.AboutModal;
import am.aua.page.buzz.BuzzPage;
import am.aua.page.dashboard.DashboardPage;
import am.aua.page.myinfo.MyInfoPage;
import org.testng.annotations.Test;

import java.util.UUID;

import static am.aua.Constants.ADMIN_PASSWORD;
import static am.aua.Constants.ADMIN_USERNAME;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BuzzTest extends BaseTest{

    @Test
    public void testCreatingBuzz() {
        loginPage.enterUsername(ADMIN_USERNAME);
        loginPage.enterPassword(ADMIN_PASSWORD);

        DashboardPage dashboardPage = loginPage.clickSubmit();

        AboutModal aboutModal = dashboardPage.getHeader().clickAbout();
        aboutModal.close();
        MyInfoPage myInfoPage = dashboardPage.getNavigationBar().clickMyInfo();
        BuzzPage buzzPage = myInfoPage.getNavigationBar().clickBuzzPage();
        String post = UUID.randomUUID().toString();

        buzzPage.submitPostWithText(post);

        assertThat(buzzPage.getLatestPost())
                .isEqualTo(post);
    }
}
