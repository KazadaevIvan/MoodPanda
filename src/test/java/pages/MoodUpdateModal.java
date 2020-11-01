package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MoodUpdateModal extends BaseModal {

    public static final String GO_TO_MY_DIARY_BUTTON_CSS = ".ButtonMyDiary";

    @Step("Verify Mood Update modal is opened")
    @Override
    public BaseModal isModalOpened() {
        $(GO_TO_MY_DIARY_BUTTON_CSS).waitUntil(Condition.visible, 10000);
        return this;
    }

    @Step("Click Go to My Diary button")
    public MyDiaryPage goToMyDiary() {
        $(GO_TO_MY_DIARY_BUTTON_CSS).click();
        return new MyDiaryPage();
    }
}
