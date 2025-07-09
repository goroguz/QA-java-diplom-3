package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private final WebDriver driver;
    private final By loginLink = By.xpath("//a[@href='/login']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToLoginFromRestoreForm() {
        driver.findElement(loginLink).click();
    }
}