package org.praktikum.api;

import io.qameta.allure.Step;

public class RegisterUser extends Constants{
    User user;

    public RegisterUser(User user) {
        this.user = user;
    }

    @Step("Регистрация пользователя")
    public void registerUser() {
        doPostRequest(getREGISTER_USER_URL(), user);
    }
}
