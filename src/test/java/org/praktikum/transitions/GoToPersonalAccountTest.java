package org.praktikum.transitions;

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

public class GoToPersonalAccountTest extends TestPattern {
    User user = new User();
    @Before
    public void getUrl() {
        RegisterUser registerUser = new RegisterUser(user);
        registerUser.registerUser();
        webdriver.get(APP_URL + "/login");
    }

    @Test
    @DisplayName("Переход в личный кабинет ")
    @Description("Проверяем переход по клику на «Личный кабинет»")
    public void goToPersonalAccountTest() {
        LoginPage loginPage = new LoginPage(webdriver);
        MainPage loginUser = loginPage.loginUser(user);
        PersonalAccountPage personalAccountPage = loginUser.goToPersonalAccountPage();

        Assert.assertEquals("В этом разделе вы можете изменить свои персональные данные", personalAccountPage.getPageDescription());
    }

    @After
    public void deleteUser() {
        new LoginUser(user).deleteUser();
    }

}
