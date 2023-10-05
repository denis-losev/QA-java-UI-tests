package org.praktikum.login;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.praktikum.TestPattern;
import org.praktikum.api.LoginUser;
import org.praktikum.api.RegisterUser;
import org.praktikum.api.User;
import org.praktikum.page_object_model.LoginPage;
import org.praktikum.page_object_model.MainPage;
import org.praktikum.page_object_model.PersonalAccountPage;

public class LogOutTest extends TestPattern {
    User user = new User();
    @Before
    public void getUrl() {
        RegisterUser registerUser = new RegisterUser(user);
        registerUser.registerUser();
        webdriver.get(APP_URL);
    }

    @Test
    @DisplayName("Выход пользователя из системы")
    @Description("Кликаем кнопку Выйти")
    public void logOutUserTest() {
        LoginPage clickLogin = new MainPage(webdriver).clickLoginBtn("//button[contains(text(),'Войти в аккаунт')]");
        MainPage loginUser = clickLogin.loginUser(user);
        PersonalAccountPage personalAccountPage = loginUser.goToPersonalAccountPage();
        LoginPage logOutUser = personalAccountPage.logOutUser();
        Assert.assertEquals("Войти", logOutUser.getLoginButtonText());
    }

    @After
    public void clearData(){
        new LoginUser(user).deleteUser();
    }
}
