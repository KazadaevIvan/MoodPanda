package pages;

public enum Date {
    OLDER("Older"), THREE_DAYS_AGO("3 days ago"), TWO_DAYS_AGO("2 days ago"), YESTERDAY("Yesterday"), NOW("Now");

    public final String value;

    Date(String value) {
        this.value = value;
    }
}
