package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private final WebDriver driver;

    private final By nameInput = By.xpath("//label[text()='Имя']/following-sibling::input");
    private final By emailInput = By.xpath("//label[text()='Email']/following-sibling::input");
    private final By passwordInput = By.xpath("//input[@type='password']");
    private final By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By errorText = By.xpath("//p[@class='input__error text_type_main-default']");
    private final By loginLink = By.xpath("//a[@href='/login']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнение формы регистрации")
    public void fillName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    @Step("Заполнение формы регистрации с email {email}")
    public void fillEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Заполнение формы регистрации с паролем {password}")
    public void fillPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Клик по кнопке 'Зарегистрироваться'")
    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    @Step("Получение текста ошибки при регистрации")
    public String getErrorText() {
        return driver.findElement(errorText).getText();
    }

    @Step("Регистрация пользователя с именем {name}, email {email} и паролем {password}")
    public void register(String name, String email, String password) {
        fillName(name);
        fillEmail(email);
        fillPassword(password);
        clickRegister();
    }

    @Step("Переход к форме входа из формы регистрации")
    public void goToLogin() {
        driver.findElement(loginLink).click();
    }

    @Step("Ожидание редиректа на страницу входа")
    public void waitForLoginRedirect() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.urlContains("/login"));
    }
}
