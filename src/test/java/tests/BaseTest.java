package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    public static final String CHROMEDRIVER_PATH = "/Users/A13039316/Downloads/chromedriver-mac-arm64/chromedriver";
    public static final String YANDEX_BINARY_PATH = "/Applications/Yandex.app/Contents/MacOS/Yandex";
    public static final String YANDEXDRIVER_PATH = "/Users/you/Downloads/yandexdriver";
    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    protected WebDriver driver;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");

        if ("chrome".equalsIgnoreCase(browser)) {
            System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
            driver = new ChromeDriver();
        } else if ("yandex".equalsIgnoreCase(browser)) {
            System.setProperty("webdriver.chrome.driver", YANDEXDRIVER_PATH);

            ChromeOptions options = new ChromeOptions();
            options.setBinary(YANDEX_BINARY_PATH);

            driver = new ChromeDriver(options);
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.get(URL);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}