package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.LoginPage;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
public class BaseTest {

    LoginPage loginPage;
    String email = System.getenv().getOrDefault("email", PropertyReader.getProperty("email"));
    String password = System.getenv().getOrDefault("password", PropertyReader.getProperty("password"));

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        Configuration.headless = true;
        loginPage = new LoginPage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }
}
