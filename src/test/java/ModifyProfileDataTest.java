import helpers.Common;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.ProfilePage;

import static org.junit.Assert.assertTrue;

public class ModifyProfileDataTest {

    Common common = new Common();
    HomePage homePage = new HomePage();
    ProfilePage profilePage = new ProfilePage();

    private static final String EMAIL = "mambetov_a@inbox.lv";
    private static final String PASSWORD = "testpwd001";

    @Test
    public void ModifyProfileData() throws InterruptedException {
        common.setUp();
        common.openApplication();
        homePage.populateLoginForm(EMAIL, PASSWORD);
        profilePage.editProfile(profilePage.generateRandomString(), profilePage.generateRandomString(), profilePage.generateRandomNumber(1, 28), profilePage.selectRandomMonth(), profilePage.generateRandomNumber(1945, 2020));
        assertTrue(profilePage.getNotificationMsg());
        common.tearDown();
    }
}
