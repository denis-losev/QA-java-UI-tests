package org.praktikum.api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.openqa.selenium.WebDriver;

public class LoginUser extends Constants {
    User user;
    WebDriver webdriver;

    public LoginUser(User user) {
        this.user = user;
    }

    @Step("Логин юзера в системе")
    public ValidatableResponse loginUser() {
        User loginData = new User(user.getEmail(), user.getPassword());
        return doPostRequest(getLOGIN_USER_URL(), loginData);
    }

    @Step("Получение accessToken")
    public String getAccessToken() {
        return loginUser().extract().body().as(Token.class).getAccessToken();
    }

    @Step("Удаление пользователя")
    public void deleteUser() {
        doDeleteRequest(getAUTH_USER_URL(), getAccessToken());
    }
}
