package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;

    private final By loginAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By personalCabinetButton = By.xpath("//p[text()='Личный Кабинет']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginAccount() {
        driver.findElement(loginAccountButton).click();
    }

    public void clickPersonalCabinet() {
        driver.findElement(personalCabinetButton).click();
    }
}
