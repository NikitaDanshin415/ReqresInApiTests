package api;

import api.models.response.UserListModelResponse;
import api.models.response.UserModelResponse;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserController {

    @Step("Отправляем GET запрос api/users/{id}")
    public UserModelResponse getUser(int id) {
        ValidatableResponse response = given()
                .get("https://reqres.in/api/users/" + id)
                .then()
                .statusCode(200);

        Allure.addAttachment("response", response.extract().asPrettyString());

        return response.extract()
                .jsonPath()
                .getObject("", UserModelResponse.class);
    }

    @Step("Отправляем GET запрос aapi/users?page={pageId}")
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


}
