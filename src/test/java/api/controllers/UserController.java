package api.controllers;

import api.helpers.Attacher;
import api.helpers.Specification;
import api.models.response.UserListModelResponse;
import api.models.response.UserModelResponse;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserController {
    Specification spec;

    public UserController() {
        spec = new Specification();
    }

    @Step("Отправляем GET запрос api/users/{id}")
    public UserModelResponse getUser(int id) {
        ValidatableResponse response =
                given()
                        .spec(spec.getRequestSpecification())
                        .pathParams("id", id)
                        .when()
                        .get("/api/users/{id}")
                        .then()
                        .spec(spec.getResponseSpecification());

        Allure.addAttachment("response", response.extract().asPrettyString());

        return response.extract()
                .jsonPath()
                .getObject("", UserModelResponse.class);
    }

    @Step("Отправляем GET запрос api/users?page={pageId}")
    public UserListModelResponse getUsersList(int pageId) {
        ValidatableResponse response = given()
                .get("https://reqres.in/api/users?page=" + pageId)
                .then()
                .statusCode(200);

        Allure.addAttachment("response", response.extract().asPrettyString());

        return response.extract()
                .jsonPath()
                .getObject("", UserListModelResponse.class);
    }

    @Step("Отправляем GET запрос api/users/23")
    public void get404() {
        Response response = given()
                .get("https://reqres.in/api/users/23");

        assertThat(response.getStatusCode())
                .isEqualTo(404);

        new Attacher()
                .expectationAndReality(404, response.getStatusCode());
    }
}
