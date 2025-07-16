package pom;

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

    public void fillName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void fillEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void fillPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    public String getErrorText() {
        return driver.findElement(errorText).getText();
    }

    public void register(String name, String email, String password) {
        fillName(name);
        fillEmail(email);
        fillPassword(password);
        clickRegister();
    }

    public void goToLogin() {
        driver.findElement(loginLink).click();
    }

    public void waitForLoginRedirect() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.urlContains("/login"));
    }
}
