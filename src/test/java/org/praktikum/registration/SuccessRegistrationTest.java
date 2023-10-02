package org.praktikum.registration;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.praktikum.TestPattern;
import org.praktikum.api.LoginUser;
import org.praktikum.api.User;
import org.praktikum.page_object_model.LoginPage;
import org.praktikum.page_object_model.RegistrationPage;

import java.time.Duration;

public class SuccessRegistrationTest extends TestPattern {
    User user = new User();
    @Before
    public void getUrl() {
        webdriver.get(getAPP_URL() + "/register");
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void successRegistration() {
        RegistrationPage registrationPage = new RegistrationPage(webdriver);
        LoginPage loginPage = registrationPage.registerUser(user);
        new WebDriverWait(webdriver, Duration.ofSeconds(3))
                .until(ExpectedConditions.urlContains("login"));
        Assert.assertEquals("Вход", loginPage.getPageName());
    }

    @After
    public void deleteUser() {
        new LoginUser(user).deleteUser();
    }
}
