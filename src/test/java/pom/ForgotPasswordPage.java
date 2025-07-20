package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private final WebDriver driver;
    private final By loginLink = By.xpath("//a[@href='/login']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Переход к форме восстановления пароля")
    public void goToLoginFromRestoreForm() {
        driver.findElement(loginLink).click();
    }
}