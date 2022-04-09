package api.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.qameta.allure.Step;
import lombok.Data;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserListModelResponse {
    int page;
    @JsonProperty("per_page")
    int perPage;
    int total;
    @JsonProperty("total_pages")
    int totalPages;
    UserData[] data;

    @Step("Id страницы должен быть равен : {pageId}")
    public UserListModelResponse pageIdIsEqual(int pageId) {
        assertThat(this.getPage()).isEqualTo(pageId);
        return this;
    }

    @Step("PerPage должен быть равен {perPage}")
    public UserListModelResponse perPageIsEqual(int perPage) {
        assertThat(this.getPerPage()).isEqualTo(perPage);
        return this;
    }

    @Step("total должен быть равен {total}")
    public UserListModelResponse totalIsEqual(int total) {
        assertThat(this.getTotal()).isEqualTo(total);
        return this;
    }

    @Step("totalPages должен быть равен {totalPages}")
    public UserListModelResponse totalPagesIsEqual(int totalPages) {
        assertThat(this.getTotalPages()).isEqualTo(totalPages);
        return this;
    }

    @Step("Количество полученных пользователей совпадает с perPage")
    public UserListModelResponse dataHasCurrentSize() {
        assertThat(this.getData().length).isEqualTo(this.getPerPage());
        return this;
    }
}
