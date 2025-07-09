package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConstructorPage {
    private final WebDriver driver;

    private final By bunTab = By.xpath("//span[text()='Булки']");
    private final By sauceTab = By.xpath("//span[text()='Соусы']");
    private final By fillingTab = By.xpath("//span[text()='Начинки']");

    private final By sauceSection = By.xpath("//h2[text()='Соусы']");
    private final By fillingSection = By.xpath("//h2[text()='Начинки']");
    private final By activeTab = By.cssSelector(".tab_tab__1SPyG.tab_tab_type_current__2BEPc");

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBunsTab() {
        driver.findElement(bunTab).click();
    }

    public void clickSaucesTab() {
        driver.findElement(sauceTab).click();
    }

    public void clickFillingsTab() {
        driver.findElement(fillingTab);
    }

    public boolean isSaucesSectionVisible() {
        return isElementVisible(sauceSection);
    }

    public boolean isFillingsSectionVisible() {
        return isElementVisible(fillingSection);
    }

    private boolean isElementVisible(By locator) {
        WebElement element = driver.findElement(locator);
        return element.isDisplayed();
    }

    public boolean isBunsTabActive() {
        String text = driver.findElement(activeTab).getText();
        return "Булки".equals(text);
    }
}