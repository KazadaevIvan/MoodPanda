package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FeedPage extends BasePage {
    public static final String URL = "https://moodpanda.com/Feed/";
    public static final String UPDATE_MOOD_CSS = "#LinkUpdate";

    @Step("Open Feed page")
    @Override
    public FeedPage openPage() {
        open(URL);
        return this;
    }

    @Step("Verify Feed page is opened")
    public FeedPage isPageOpened() {
        $(UPDATE_MOOD_CSS).waitUntil(Condition.visible, 10000);
        return this;
    }

    @Step("Click Update mood button")
    public RateYourHappinessModal clickUpdate() {
        $(UPDATE_MOOD_CSS).click();
        return new RateYourHappinessModal();
    }
}
