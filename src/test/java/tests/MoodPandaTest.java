package tests;

import org.testng.annotations.Test;
import pages.Date;

public class MoodPandaTest extends BaseTest {

    @Test(description = "Verify that post could be created with date 'Older'")
    public void postWithDateOlderShouldBeCreated() {
        loginPage
                .openPage()
                .login(email, password)
                .isPageOpened()
                .clickUpdate()
                .updateMood(5, "Description", Date.OLDER.value, "2019", "Dec", "26",
                        "3 am", ":45")
                .goToMyDiary()
                .isPageOpened()
                .validateMood(5, "Description", "2019", "Dec", "26");
    }

    @Test(description = "Verify that post could be created with date '3 days ago'")
    public void postWithDateThreeDaysAgoShouldBeCreated() {
        loginPage
                .openPage()
                .login(email, password)
                .isPageOpened()
                .clickUpdate()
                .updateMood(1, "Description", Date.THREE_DAYS_AGO.value, "1 pm", ":30")
                .goToMyDiary()
                .isPageOpened()
                .validateMood(1, "Description");
    }

    @Test(description = "Verify that post could be created with date '2 days ago'")
    public void postWithDateTwoDaysAgoShouldBeCreated() {
        loginPage
                .openPage()
                .login(email, password)
                .isPageOpened()
                .clickUpdate()
                .updateMood(10, "Description", Date.TWO_DAYS_AGO.value, "9 pm", ":15")
                .goToMyDiary()
                .isPageOpened()
                .validateMood(10, "Description");
    }

    @Test(description = "Verify that post could be created with date 'Yesterday'")
    public void postWithDateYesterdayAgoShouldBeCreated() {
        loginPage
                .openPage()
                .login(email, password)
                .isPageOpened()
                .clickUpdate()
                .updateMood(9, "Description", Date.YESTERDAY.value, "Midday", ":00")
                .goToMyDiary()
                .isPageOpened()
                .validateMood(9, "Description");
    }

    @Test(description = "Verify that post could be created with date 'Now'")
    public void postWithDateNowShouldBeCreated() {
        loginPage
                .openPage()
                .login(email, password)
                .isPageOpened()
                .clickUpdate()
                .updateMood(2, "Description", Date.NOW.value)
                .goToMyDiary()
                .isPageOpened()
                .validateMood(2, "Description");
    }
}
