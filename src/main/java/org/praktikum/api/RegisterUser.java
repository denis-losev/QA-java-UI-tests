package org.praktikum.api;

import io.qameta.allure.Step;

public class RegisterUser extends Requests {
    User user;

    public RegisterUser(User user) {
        this.user = user;
    }

    public void registerUser() {
        doPostRequest(REGISTER_USER_URL, user);
    }
}
