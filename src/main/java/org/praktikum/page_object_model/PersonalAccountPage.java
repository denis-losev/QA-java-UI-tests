package org.praktikum.page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.praktikum.api.Constants;

import java.time.Duration;

public class PersonalAccountPage extends Constants {
    private final WebDriver webdriver;
    private final By description = By.xpath("//p[@class='Account_text__fZAIn text text_type_main-default']");
    private final By logOutBtn = By.xpath("//button[contains(text(),'Выход')]");
    public PersonalAccountPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public String getPageDescription() {
        return webdriver.findElement(description).getText();
    }
    public MainPage goToConstructorPage(String btn) {
        webdriver.findElement(By.xpath(btn)).click();
        new WebDriverWait(webdriver, Duration.ofSeconds(3))
                .until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return new MainPage(webdriver);
    }

    public LoginPage logOutUser() {
        webdriver.findElement(logOutBtn).click();
        new WebDriverWait(webdriver, Duration.ofSeconds(3))
                .until(ExpectedConditions.urlContains("login"));
        return new LoginPage(webdriver);
    }
}
