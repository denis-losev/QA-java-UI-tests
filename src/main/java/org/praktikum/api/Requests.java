package org.praktikum.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Requests extends Endpoints{

    public ValidatableResponse doPostRequest(String url, Object body) {
        RequestSpecification request = given(baseRequest());
        request.body(body);
        return request.post(url).then();
    }
    public void doDeleteRequest(String url, String token) {
        RequestSpecification request = given(baseRequest());
        request.header("Authorization", token);
        request.delete(url).then();
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
