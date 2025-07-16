package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorPage {
    private final WebDriver driver;

    private final By sauceTab = By.xpath("//span[text()='Соусы']");
    private final By fillingTab = By.xpath("//span[text()='Начинки']");

    private final By activeTab = By.cssSelector(".tab_tab__1SPyG.tab_tab_type_current__2BEPc");

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSaucesTab() {
        driver.findElement(sauceTab).click();
    }

    public void clickFillingsTab() {
        WebElement tab = driver.findElement(fillingTab);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tab);
        tab.click();

        // Дождаться, пока вкладка станет активной
        new WebDriverWait(driver, Duration.ofSeconds(3))
            .until(ExpectedConditions.attributeContains(
                By.xpath("//span[text()='Начинки']/ancestor::div[contains(@class,'tab_tab__')]"),
                "class",
                "tab_tab_type_current__"
            ));
    }


    public boolean isBunsTabActive() {
        String text = driver.findElement(activeTab).getText();
        return "Булки".equals(text);
    }

    public boolean isSaucesTabActive() {
        String tabText = driver.findElement(activeTab).getText();
        return "Соусы".equals(tabText);
    }

    public boolean isFillingsTabActive() {
        String text = driver.findElement(activeTab).getText();
        return "Начинки".equals(text);
    }
}