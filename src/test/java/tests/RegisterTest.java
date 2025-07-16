package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.junit.Test;
import pom.RegisterPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterTest extends BaseTest {
    private final Faker faker = new Faker();

    @Test
    @Description("Успешная регистрация нового пользователя")
    public void testSuccessfulRegistration() {
        driver.get(URL + "register");
        RegisterPage registerPage = new RegisterPage(driver);

        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password(8, 16, true, true);

        registerPage.register(name, email, password);
        registerPage.waitForLoginRedirect();
        assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    @Description("Регистрация с слишком коротким email")
    public void testShortPasswordError() {
        driver.get(URL + "register");
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.register(faker.name().fullName(), faker.internet().emailAddress(), faker.internet().password(1, 3, true, true));

        String errorMessage = registerPage.getErrorText();
        assertEquals("Некорректный пароль", errorMessage);
    }
}