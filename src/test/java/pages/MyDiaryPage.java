package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

public class MyDiaryPage extends BasePage {
    public static final String URL = "https://moodpanda.com/Feed/?Me=1";
    public static final String DATE_CSS = ".text-muteda:first-child";
    public static final String MOOD_RATING_CSS = ".badge.pull-right";
    public static final String DESCRIPTION = "(//*[contains(@class,'media-content')])[1]";
    public static final String SHOW_OLDER_BUTTON_CSS = "#ContentPlaceHolderContent_ButtonNext";

    @Step("Open My Diary page")
    @Override
    public MyDiaryPage openPage() {
        open(URL);
        return this;
    }

    @Step("Verify My Diary page is opened")
    @Override
    public MyDiaryPage isPageOpened() {
        $(SHOW_OLDER_BUTTON_CSS).waitUntil(Condition.visible, 10000);
        return this;
    }

    @Step("Validate mood. Mood rating should be '{moodRating}', description '{description}'")
    public MyDiaryPage validateMood(int moodRating, String description, String year, String month,
                                    String day) {

        String date = $(DATE_CSS).getText();
        assertEquals(date.substring(0, date.indexOf('·')).trim(), dateConstructor(year, month, day),
                "Date should be " + dateConstructor(year, month, day));
        assertEquals($(MOOD_RATING_CSS).getText(), String.valueOf(moodRating), "Mood rating should be " + moodRating);
        $(By.xpath(DESCRIPTION)).waitUntil(Condition.visible, 10000);
        assertEquals($(By.xpath(DESCRIPTION)).getText(), description, "Description should be " + description);
        return this;
    }

    @Step("Validate mood. Mood rating should be '{moodRating}', description '{description}'")
    public MyDiaryPage validateMood(int moodRating, String description) {

        assertEquals($(MOOD_RATING_CSS).getText(), String.valueOf(moodRating), "Mood rating should be " + moodRating);
        assertEquals($(By.xpath(DESCRIPTION)).getText(), description, "Description should be " + description);
        return this;
    }

    public String dateConstructor(String year, String month, String day) {
        return day + " " + month + " " + year;
    }
}
