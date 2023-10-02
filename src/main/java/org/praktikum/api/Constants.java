package org.praktikum.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Constants {
    private final String APP_URL = "https://stellarburgers.nomoreparties.site";
    private final String REGISTER_USER_URL = "/api/auth/register";
    private final String AUTH_USER_URL = "/api/auth/user";
    private final String LOGIN_USER_URL = "/api/auth/login";

    public String getAPP_URL() {
        return APP_URL;
    }

    public String getREGISTER_USER_URL() {
        return REGISTER_USER_URL;
    }
    public String getAUTH_USER_URL() {
        return AUTH_USER_URL;
    }

    public String getLOGIN_USER_URL() {
        return LOGIN_USER_URL;
    }

    public ValidatableResponse doPostRequest(String url, Object body) {
        RequestSpecification request = given(baseRequest());
        request.body(body);
        return request.post(url).then();
    }
    public ValidatableResponse doDeleteRequest(String url, String token) {
        RequestSpecification request = given(baseRequest());
        request.header("Authorization", token);
        return request.delete(url).then();
    }
    public RequestSpecification baseRequest() {
        return new RequestSpecBuilder()
                .setBaseUri(APP_URL)
                .setContentType(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .setRelaxedHTTPSValidation()
                .build();
    }
}
