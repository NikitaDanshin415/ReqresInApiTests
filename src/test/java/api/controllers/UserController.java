package api.controllers;

import api.helpers.Attacher;
import api.helpers.spec.RequestSpec;
import api.helpers.spec.ResponseSpec;
import api.models.request.UserModelPostRequest;
import api.models.response.UserListModelResponse;
import api.models.response.UserModelPostResponse;
import api.models.response.UserModelResponse;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserController {
    RequestSpec requestSpec;
    ResponseSpec responseSpec;

    public UserController() {
        requestSpec = new RequestSpec();
        responseSpec = new ResponseSpec();
    }

    @Step("Отправляем GET запрос api/users/{id}")
    public UserModelResponse getUser(int id) {
        ValidatableResponse response = given()
            .spec(requestSpec.getRequestSpecification())
            .pathParams("id", id)
            .when()
            .get("/api/users/{id}")
            .then()
            .spec(responseSpec.getResponseSpecification());

        Allure.addAttachment("response", response.extract().asPrettyString());

        return response.extract()
            .jsonPath()
            .getObject("", UserModelResponse.class);
    }

    @Step("Отправляем GET запрос api/users?page={pageId}")
    public UserListModelResponse getUsersList(int pageId) {
        ValidatableResponse response = given()
            .spec(requestSpec.getRequestSpecification())
            .get("https://reqres.in/api/users?page=" + pageId)
            .then()
            .spec(responseSpec.getResponseSpecification());

        Allure.addAttachment("response", response.extract().asPrettyString());

        return response.extract()
            .jsonPath()
            .getObject("", UserListModelResponse.class);
    }

    @Step("Отправляем GET запрос api/users/23")
    public void get404() {
        Response response = given()
            .spec(requestSpec.getRequestSpecification())
            .get("/api/users/23");

        assertThat(response.getStatusCode())
            .isEqualTo(404);

        new Attacher()
            .expectationAndReality(404, response.getStatusCode());
    }


    @Step("Отправляем POST запрос api/users/")
    public UserModelPostResponse createUser(UserModelPostRequest user) {

        Allure.addAttachment("request data", user.toString());

        ValidatableResponse response = given()
            .spec(requestSpec.postRequestSpecification())
            .body(user)
            .post("/api/users")
            .then()
            .spec(responseSpec.postResponseSpecification());

        Allure.addAttachment("response", response.extract().asPrettyString());

        return response.extract()
            .jsonPath()
            .getObject("", UserModelPostResponse.class);
    }

    @Step("Отправляем DELETE запрос api/users/{id}")
    public void deleteUser(int id) {
        Response response = given()
            .spec(requestSpec.getRequestSpecification())
            .delete("/api/users/" + id);

        assertThat(response.getStatusCode())
            .isEqualTo(204);

        new Attacher()
            .expectationAndReality("Проверка статус кода ответа", 204, response.getStatusCode());
    }
}
