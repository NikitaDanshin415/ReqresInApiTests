import api.UserController;
import api.models.response.UserListModelResponse;
import api.models.response.UserModelResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;


public class RequestInTests {
    UserController userController = new UserController();

    @Test
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
}
