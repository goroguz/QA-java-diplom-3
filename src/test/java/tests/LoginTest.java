package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.ForgotPasswordPage;
import pom.LoginPage;
import pom.MainPage;
import pom.RegisterPage;
import service.UserService;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    private final static UserService userService = new UserService();
    private static String accessToken;
    private static String userName;
    private static String email;
    private static String password;

    private void waitUntilMainPageLoaded() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.urlToBe(URL));
    }

    @BeforeClass
    public static void creteUser() {
        Faker faker = new Faker();
        password = faker.internet().password(8, 16, true, true);
        userName = faker.name().fullName();
        email = faker.internet().emailAddress();

        Response registerResponse = userService.createUser(email, password, userName);
        accessToken = registerResponse.then().extract().path("accessToken");
    }

    @Test
    @Description("вход по кнопке «Войти в аккаунт» на главной")
    public void loginFromMainPageButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginAccount();

        loginAndAssert();
    }

    @Test
    @Description("вход через кнопку «Личный кабинет»")
    public void loginFromPersonalCabinetButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalCabinet();

        loginAndAssert();
    }

    @Test
    @Description("вход через кнопку в форме регистрации")
    public void loginFromRegisterPage() {
        driver.get(URL + "register");
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.goToLogin();

        loginAndAssert();
    }

    @Test
    @Description("вход через кнопку «Войти в аккаунт» на странице восстановления пароля")
    public void loginFromForgotPasswordPage() {
        driver.get(URL + "forgot-password");
        ForgotPasswordPage forgotPage = new ForgotPasswordPage(driver);
        forgotPage.goToLoginFromRestoreForm();

        loginAndAssert();
    }

    @Step
    private void loginAndAssert() {
        new LoginPage(driver).login(email, password);
        waitUntilMainPageLoaded();
        assertTrue(driver.getCurrentUrl().equals(URL));
    }

    @AfterClass
    public static void deleteUser() {
        if (accessToken != null) {
            userService.deleteUser(accessToken)
                .then()
                .statusCode(202);
        }
    }
}