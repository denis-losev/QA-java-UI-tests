package org.praktikum.transitions;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.praktikum.TestPattern;
import org.praktikum.api.LoginUser;
import org.praktikum.api.RegisterUser;
import org.praktikum.api.User;
import org.praktikum.page_object_model.LoginPage;
import org.praktikum.page_object_model.MainPage;
import org.praktikum.page_object_model.PersonalAccountPage;
@RunWith(Parameterized.class)
public class GoToConstructorPageTest extends TestPattern {
    User user = new User();
    private String button;

    public GoToConstructorPageTest(String button) {
        this.button = button;
    }

    @Parameterized.Parameters(name = "Button: {0}")
    public static Object[][] getParams() {
        return new Object[][] {
                {"//p[contains(text(),'Конструктор')]"},
                {".//*[@id='root']/div/header/nav/div/a"}
        };
    }
    @Before
    public void getUrl() {
        RegisterUser registerUser = new RegisterUser(user);
        registerUser.registerUser();
        webdriver.get(getAPP_URL());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор ")
    @Description("Переход по клику на «Конструктор» и на логотип Stellar Burgers")
    public void goToConstructorPageTest() {
        LoginPage clickLogin = new MainPage(webdriver).clickLoginBtn("//button[contains(text(),'Войти в аккаунт')]");
        MainPage loginUser = clickLogin.loginUser(user);
        PersonalAccountPage personalAccountPage = loginUser.goToPersonalAccountPage();
        MainPage constructorPage = personalAccountPage.goToConstructorPage(button);
        Assert.assertEquals("Соберите бургер", constructorPage.getCollectBurgerHeaderText());
    }

    @After
    public void clearData(){
        new LoginUser(user).deleteUser();
    }
}
