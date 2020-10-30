package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    public static final String URL = "https://moodpanda.com/Login/";
    public static final String EMAIL_CSS = "#ContentPlaceHolderContent_TextBoxEmail";
    public static final String PASSWORD_CSS = "#ContentPlaceHolderContent_TextBoxPassword";
    public static final String LOGIN_BUTTON_CSS = "#ContentPlaceHolderContent_ButtonLogin";
    public static final String GP_ICON_CSS = "[alt='MoodPanda Android App on Google Play']";

    public FeedPage login(String email, String password) {
        $(EMAIL_CSS).sendKeys(email);
        $(PASSWORD_CSS).sendKeys(password);
        $(LOGIN_BUTTON_CSS).click();
        return new FeedPage();
    }

    public LoginPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    public void isPageOpened() {
        $(GP_ICON_CSS).waitUntil(Condition.visible, 10000);
    }
}
