package org.praktikum.login;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.praktikum.TestPattern;
import org.praktikum.api.LoginUser;
import org.praktikum.api.RegisterUser;
import org.praktikum.api.User;
import org.praktikum.page_object_model.LoginPage;
import org.praktikum.page_object_model.MainPage;

import java.time.Duration;

@RunWith(Parameterized.class)
public class LoginTest extends TestPattern {
    private final String URL;
    private final String button;
    User user = new User();

    public LoginTest(String URL, String button) {
        this.URL = URL;
        this.button = button;
    }

    @Parameterized.Parameters(name = "URL: {0}, button: {1}")
    public static Object[][] getParams() {
        return new Object[][] {
                {"https://stellarburgers.nomoreparties.site", "//button[contains(text(),'Войти в аккаунт')]"},
                {"https://stellarburgers.nomoreparties.site", "//p[contains(text(),'Личный Кабинет')]"},
                {"https://stellarburgers.nomoreparties.site/register", "//a[contains(text(),'Войти')]"},
                {"https://stellarburgers.nomoreparties.site/forgot-password", "//a[contains(text(),'Войти')]"}
        };
    }
    @Before
    public void getUrl() {
        RegisterUser registerUser = new RegisterUser(user);
        registerUser.registerUser();
        webdriver.get(URL);
    }
    @Test
    @DisplayName("Проверка входа из различных частей приложения")
    @Description("вход по кнопке «Войти в аккаунт» на главной,\n" +
            "вход через кнопку «Личный кабинет»,\n" +
            "вход через кнопку в форме регистрации,\n" +
            "вход через кнопку в форме восстановления пароля.")
    public void loginTest() {
        MainPage startPage = new MainPage(webdriver);
        LoginPage loginUser = startPage.clickLoginBtn(button);
        By doOrder = By.xpath("//button[contains(text(),'Оформить заказ')]");
        loginUser.loginUser(user);
        new WebDriverWait(webdriver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(doOrder));
        Assert.assertEquals("Оформить заказ", webdriver.findElement(doOrder).getText());
    }

    @After
    public void clearData(){
        new LoginUser(user).deleteUser();
    }
}
