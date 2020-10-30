package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FeedPage extends BasePage {
    public static final String URL = "https://moodpanda.com/Feed/";
    public static final String UPDATE_MOOD_CSS = "#LinkUpdate";

    @Override
    public FeedPage openPage() {
        open(URL);
        return this;
    }

    public FeedPage isPageOpened() {
        $(UPDATE_MOOD_CSS).waitUntil(Condition.visible, 10000);
        return this;
    }

    public RateYourHappinessModal clickUpdate() {
        $(UPDATE_MOOD_CSS).click();
        return new RateYourHappinessModal();
    }
}
