package org.praktikum.page_object_model;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.praktikum.api.User;

public class LoginPage {
    private final WebDriver webdriver;
    private final By emailField = By.xpath("(//input[@name='name'])[1]");
    private final By passwordField = By.xpath("(//input[@name='Пароль'])[1]");
    private final By loginBtn = By.xpath("//button[contains(text(),'Войти')]");
    private final By pageTitle = By.xpath("//h2[contains(text(),'Вход')]");

    public LoginPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public String getPageName() {
        return webdriver.findElement(pageTitle).getText();
    }
    public String getLoginButtonText() {
        return webdriver.findElement(loginBtn).getText();
    }

    public MainPage loginUser(@NotNull User user) {
        fillLoginForm(user.getEmail(), user.getPassword());
        clickLoginBtn();
        return new MainPage(webdriver);
    }

    public void fillLoginForm(String email, String password) {
        webdriver.findElement(emailField).sendKeys(email);
        webdriver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginBtn() {
        webdriver.findElement(loginBtn).click();
    }
}
