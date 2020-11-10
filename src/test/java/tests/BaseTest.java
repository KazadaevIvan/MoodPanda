package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.LoginPage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
public class BaseTest {

    LoginPage loginPage;
    String email = System.getProperty("email");
    String password = System.getProperty("password");

    @BeforeMethod
    public void setUp() {
        Configuration.browser = System.getProperty("browser");
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        Configuration.headless = Boolean.getBoolean("headless");
        loginPage = new LoginPage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }
}
