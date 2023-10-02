package org.praktikum.page_object_model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver webdriver;
    private final By personalAccountBtn = By.xpath("(//p[contains(text(),'Личный Кабинет')])[1]");
    private final By collectBurgerHeader = By.xpath("//h1[contains(text(),'Соберите бургер')]");
    public MainPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public String getCollectBurgerHeaderText() {
        return webdriver.findElement(collectBurgerHeader).getText();
    }
    @Step("Кликаем по кнопке входа")
    public LoginPage clickLoginBtn(String btn) {
        webdriver.findElement(By.xpath(btn)).click();
        new WebDriverWait(webdriver, Duration.ofSeconds(3))
                .until(ExpectedConditions.urlContains("login"));
        return new LoginPage(webdriver);
    }

    public PersonalAccountPage goToPersonalAccountPage() {
        webdriver.findElement(personalAccountBtn).click();
        new WebDriverWait(webdriver, Duration.ofSeconds(3))
                .until(ExpectedConditions.urlContains("account/profile"));
        return new PersonalAccountPage(webdriver);
    }
}
