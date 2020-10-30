package tests;

import org.testng.annotations.Test;

public class MoodPandaTest extends BaseTest {

    @Test()
    public void login() {
        loginPage
                .openPage()
                .login(email, password)
                .isPageOpened()
                .clickUpdate()
                .updateMood(8, "Description", "Older", "2019", "Dec", "26",
                        "3 am", ":45")
                .goToMyDiary()
                .isPageOpened()
                .validateMood(8, "Description", "2019", "Dec", "26");
    }
}
