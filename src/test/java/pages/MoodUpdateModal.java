package pages;

import static com.codeborne.selenide.Selenide.$;

public class MoodUpdateModal {

    public static final String GO_TO_MY_DIARY_BUTTON_CSS = ".ButtonMyDiary";

    public MyDiaryPage goToMyDiary() {
        $(GO_TO_MY_DIARY_BUTTON_CSS).click();
        return new MyDiaryPage();
    }
}
