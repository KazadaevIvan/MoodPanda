package tests;

import org.testng.annotations.Test;

public class MoodPandaTest extends BaseTest {

    @Test()
    public void postWithDateOlderShouldBeCreated() {
        loginPage
                .openPage()
                .login(email, password)
                .isPageOpened()
                .clickUpdate()
                .updateMood(5, "Description", "Older", "2019", "Dec", "26",
                        "3 am", ":45")
                .goToMyDiary()
                .isPageOpened()
                .validateMood(5, "Description", "2019", "Dec", "26");
    }

    @Test()
    public void postWithDateThreeDaysAgoShouldBeCreated() {
        loginPage
                .openPage()
                .login(email, password)
                .isPageOpened()
                .clickUpdate()
                .updateMood(1, "Description", "3 days ago",
                        "1 am", ":30")
                .goToMyDiary()
                .isPageOpened()
                .validateMood(1, "Description");
    }

    @Test()
    public void postWithDateTwoDaysAgoShouldBeCreated() {
        loginPage
                .openPage()
                .login(email, password)
                .isPageOpened()
                .clickUpdate()
                .updateMood(10, "Description", "2 days ago",
                        "9 pm", ":00")
                .goToMyDiary()
                .isPageOpened()
                .validateMood(10, "Description");
    }

    @Test()
    public void postWithDateYesterdayAgoShouldBeCreated() {
        loginPage
                .openPage()
                .login(email, password)
                .isPageOpened()
                .clickUpdate()
                .updateMood(9, "Description", "Yesterday",
                        "Midday", ":15")
                .goToMyDiary()
                .isPageOpened()
                .validateMood(9, "Description");
    }

    @Test()
    public void postWithDateNowShouldBeCreated() {
        loginPage
                .openPage()
                .login(email, password)
                .isPageOpened()
                .clickUpdate()
                .updateMood(2, "Description", "Now")
                .goToMyDiary()
                .isPageOpened()
                .validateMood(2, "Description");
    }
}
