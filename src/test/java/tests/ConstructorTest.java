package tests;

import io.qameta.allure.Description;
import org.junit.Test;
import pom.ConstructorPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    @Test
    @Description("Проверка, что вкладка 'Булки' активна по умолчанию")
    public void testBunsTabIsActiveByDefault() {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        assertTrue(constructorPage.isBunsTabActive());
    }

    @Test
    @Description("Проверка открытия вкладки соусов в конструкторе бургера")
    public void testSaucesTabOpensSaucesSection() {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickSaucesTab();
        assertTrue(constructorPage.isSaucesSectionVisible());
    }

    @Test
    @Description("Проверка открытия вкладки начинок в конструкторе бургера")
    public void testFillingsTabOpensFillingsSection() {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickFillingsTab();
        assertTrue(constructorPage.isFillingsSectionVisible());
    }
}