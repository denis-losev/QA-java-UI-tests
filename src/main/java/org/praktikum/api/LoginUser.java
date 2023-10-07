package org.praktikum.api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.openqa.selenium.WebDriver;

public class LoginUser extends Requests {
    User user;
    WebDriver webdriver;

    public LoginUser(User user) {
        this.user = user;
    }

    public ValidatableResponse loginUser() {
        User loginData = new User(user.getEmail(), user.getPassword());
        return doPostRequest(LOGIN_USER_URL, loginData);
    }

    public String getAccessToken() {
        return loginUser().extract().body().as(Token.class).getAccessToken();
    }

    public void deleteUser() {
        doDeleteRequest(AUTH_USER_URL, getAccessToken());
    }
}
