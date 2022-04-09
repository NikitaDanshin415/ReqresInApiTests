package tests;

import api.controllers.UserController;
import api.models.response.UserListModelResponse;
import api.models.response.UserModelResponse;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class RequestInTests {
    UserController userController = new UserController();

    @Test
    @DisplayName("Проверка запроса GET api/users/2")
    void userSingleTest() {
        UserModelResponse response = userController
                .getUser(2);

        response.getData()
                .idIsEqualTo(2)
                .emailIsEqualTo("janet.weaver@reqres.in")
                .firstNameIsEqualTo("Janet")
                .lastNameIsEqualTo("Weaver")
                .avatarUrlIsEqualTo("https://reqres.in/img/faces/2-image.jpg");
    }

    @Test
    @DisplayName("Проверка запроса GET api/users?page=1")
    void userListTest() {
        UserListModelResponse response = userController
                .getUsersList(1);

        response
                .pageIdIsEqual(1)
                .perPageIsEqual(6)
                .totalIsEqual(12)
                .totalPagesIsEqual(2)
                .dataHasCurrentSize();
    }

    @Test
    @DisplayName("Проверка 404 ответа")
    @Description("Так как пользователя с такием Id нет в базе, должно вернуть 404")
    void user404Test() {
        userController
                .get404();
    }
}
