package org.praktikum.registration;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.praktikum.TestPattern;
import org.praktikum.api.User;
import org.praktikum.page_object_model.RegistrationPage;

@RunWith(Parameterized.class)
public class ErrorRegistrationTest extends TestPattern {
    private final String password;

    public ErrorRegistrationTest(String password) {
        this.password = password;
    }

    @Parameterized.Parameters(name = "Password: {0}")
    public static Object[][] getParams() {
        return new Object[][] {
                {"1"},
                {"asd12"}
        };
    }

    User user = new User();
    @Before
    public void getUrl() {
        webdriver.get(getAPP_URL() + "/register");
    }
    @Test
    @DisplayName("Создание пользователя с невалидным паролём")
    @Description("Минимальный валидный пароль — шесть символов")
    public void registerUserNotValidPasswordTest() {
        RegistrationPage registrationPage = new RegistrationPage(webdriver);
        user.setPassword(password);
        registrationPage.registerUser(user);
        Assert.assertEquals("Некорректный пароль", registrationPage.getPasswordErrorText());
    }
}
