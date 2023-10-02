package org.praktikum.page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorModal {
    WebDriver webdriver;
    private final By bunsBtn = By.xpath("//span[contains(text(),'Булки')]");
    private final By sauceBtn = By.xpath("//span[contains(text(),'Соусы')]");
    private final By filingBtn = By.xpath("//span[contains(text(),'Начинки')]");
    private final By bunsContainer = By.xpath("(//div)[4]/div[1]");
    private final By sauceContainer = By.xpath("(//div)[4]/div[2]");
    private final By filingContainer = By.xpath("(//div)[4]/div[3]");
    public ConstructorModal(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public By getBunsBtn() {
        return bunsBtn;
    }

    public By getSauceBtn() {
        return sauceBtn;
    }

    public By getFilingBtn() {
        return filingBtn;
    }

    public By getBunsContainer() {
        return bunsContainer;
    }

    public By getSauceContainer() {
        return sauceContainer;
    }

    public void clickBtn(By btn) {
        webdriver.findElement(btn).click();
    }

    public By getFilingContainer() {
        return filingContainer;
    }

    public String getElementClass(By by) {
        return webdriver.findElement(by).getAttribute("class");
    }
}
