package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;

    private final By loginAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By personalCabinetButton = By.xpath("//p[text()='Личный Кабинет']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по кнопке 'Войти в аккаунт'")
    public void clickLoginAccount() {
        driver.findElement(loginAccountButton).click();
    }

    @Step("Клик по кнопке 'Личный Кабинет'")
    public void clickPersonalCabinet() {
        driver.findElement(personalCabinetButton).click();
    }
}
