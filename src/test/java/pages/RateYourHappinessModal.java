package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;

public class RateYourHappinessModal {

    public static final String SLIDER_CSS = ".ui-slider-handle";
    public static final String TEXTAREA_CSS = "#TextBoxUpdateMoodTag";
    public static final String DATE = "//*[contains(text(),'%s')]";
    public static final String HOURS_SELECTOR = "#ddlHistoricHour";
    public static final String MINUTES_SELECTOR = "#ddlHistoricMinute";
    public static final String YEAR_SELECTOR = ".ui-datepicker-year";
    public static final String MONTH_SELECTOR = ".ui-datepicker-month";
    public static final String DAY = "//a[text()='%s']";
    public static final String UPDATE_BUTTON_CSS = ".btn.ButtonUpdate";

    public MoodUpdateModal updateMood(int moodRating, String description, String date) {

        setMoodRating(moodRating);
        $(TEXTAREA_CSS).sendKeys(description);
        $(By.xpath(String.format(DATE, date))).click();
        $(UPDATE_BUTTON_CSS).click();
        return new MoodUpdateModal();
    }

    public MoodUpdateModal updateMood(int moodRating, String description, String date, String hours, String minutes) {

        setMoodRating(moodRating);
        $(TEXTAREA_CSS).sendKeys(description);
        $(By.xpath(String.format(DATE, date))).click();
        setTime(hours, minutes);
        $(UPDATE_BUTTON_CSS).click();
        return new MoodUpdateModal();
    }

    public MoodUpdateModal updateMood(int moodRating, String description, String date, String year, String month,
                                      String day, String hours, String minutes) {
        setMoodRating(moodRating);
        $(TEXTAREA_CSS).sendKeys(description);
        $(By.xpath(String.format(DATE, date))).click();
        setDate(year, month, day, hours, minutes);
        $(UPDATE_BUTTON_CSS).click();
        return new MoodUpdateModal();
    }

    public void setMoodRating(int number) {
        int defaultMood = 5;

        $(SLIDER_CSS).click();
        Keys direction;
        if (number > defaultMood) {
            direction = Keys.ARROW_RIGHT;
        } else {
            direction = Keys.ARROW_LEFT;
        }
        for (int i = 0; i < Math.abs(number - defaultMood); i++) {
            $(SLIDER_CSS).sendKeys(direction);
        }
    }

    public void setTime(String hours, String minutes) {
        new Select($(HOURS_SELECTOR)).selectByVisibleText(hours);
        new Select($(MINUTES_SELECTOR)).selectByVisibleText(minutes);
    }

    public void setDate(String year, String month, String day, String hours, String minutes) {
        new Select($(YEAR_SELECTOR)).selectByVisibleText(year);
        new Select($(MONTH_SELECTOR)).selectByVisibleText(month);
        $(By.xpath(String.format(DAY, day))).click();
        setTime(hours, minutes);
    }
}
