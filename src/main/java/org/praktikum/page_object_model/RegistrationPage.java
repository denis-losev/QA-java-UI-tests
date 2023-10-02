package org.praktikum.page_object_model;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.praktikum.api.User;

import java.time.Duration;

public class RegistrationPage {
    private final WebDriver webdriver;
    private final By nameField = By.xpath("(//input[@name='name'])[1]");
    private final By emailField = By.xpath("(//input[@name='name'])[2]");
    private final By passwordField = By.xpath("//input[@name='Пароль']");
    private final By registerBtn = By.xpath("//button[contains(text(),'Зарегистрироваться')]");
    private final By passwordErrorField = By.xpath("(//p[@class='input__error text_type_main-default'])[1]");
    public RegistrationPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public void fillRegistrationForm(String name, String email, String password) {
        webdriver.findElement(nameField).sendKeys(name);
        webdriver.findElement(emailField).sendKeys(email);
        webdriver.findElement(passwordField).sendKeys(password);
    }

    public void clickRegistrationBtn() {
        webdriver.findElement(registerBtn).click();
    }

    public LoginPage registerUser(@NotNull User user) {
        fillRegistrationForm(user.getName(), user.getEmail(), user.getPassword());
        clickRegistrationBtn();
        return new LoginPage(webdriver);
    }

    public String getPasswordErrorText() {
        new WebDriverWait(webdriver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(passwordErrorField));
        return webdriver.findElement(passwordErrorField).getText();
    }
}
