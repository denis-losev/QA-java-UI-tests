package org.praktikum.page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorModal {
    WebDriver webdriver;
    private final By bunsBtn = By.xpath("//span[contains(text(),'Булки')]");
    private final By sauceBtn = By.xpath("//span[contains(text(),'Соусы')]");
    private final By filingBtn = By.xpath("//span[contains(text(),'Начинки')]");
    private final By bunsContainer = By.xpath("//div[contains(@class,'tab_tab__1SPyG')][1]");
    private final By sauceContainer = By.xpath("//div[contains(@class,'tab_tab__1SPyG')][2]");
    private final By filingContainer = By.xpath("//div[contains(@class,'tab_tab__1SPyG')][3]");
    protected final By bunsItem = By.xpath("//h2[contains(text(),'Булки')]");
    protected final By saucesItem = By.xpath("//p[contains(text(),'Соус Spicy-X')]");
    protected final By filingItem = By.xpath("//p[contains(text(),'Сыр с астероидной плесенью')]");
    public ConstructorModal(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public By getBunsContainer() {
        return bunsContainer;
    }

    public By getSauceContainer() {
        return sauceContainer;
    }

    public By getFilingContainer() {
        return filingContainer;
    }

    public By getBunsItem() {
        return bunsItem;
    }

    public By getSaucesItem() {
        return saucesItem;
    }

    public By getFilingItem() {
        return filingItem;
    }

    public String getElementClass(By by) {
        return webdriver.findElement(by).getAttribute("class");
    }

    public void scrollTo(By elemTo, By elemWait) {
        WebElement element = webdriver.findElement(elemTo);
        ((JavascriptExecutor)webdriver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(webdriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.attributeContains(elemWait, "class", "tab_tab_type_current__2BEPc"));
    }
}
