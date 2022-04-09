package api.models.response;

import api.helpers.Attacher;
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
        new Attacher()
                .expectationAndReality(pageId, this.page);

        assertThat(this.getPage()).isEqualTo(pageId);
        return this;
    }

    @Step("PerPage должен быть равен {perPage}")
    public UserListModelResponse perPageIsEqual(int perPage) {
        new Attacher()
                .expectationAndReality(perPage, this.perPage);

        assertThat(this.getPerPage()).isEqualTo(perPage);
        return this;
    }

    @Step("total должен быть равен {total}")
    public UserListModelResponse totalIsEqual(int total) {
        new Attacher()
                .expectationAndReality(total, this.total);

        assertThat(this.getTotal()).isEqualTo(total);
        return this;
    }

    @Step("totalPages должен быть равен {totalPages}")
    public UserListModelResponse totalPagesIsEqual(int totalPages) {
        new Attacher()
                .expectationAndReality(totalPages, this.totalPages);

        assertThat(this.getTotalPages()).isEqualTo(totalPages);
        return this;
    }

    @Step("Количество полученных пользователей совпадает с perPage")
    public UserListModelResponse dataHasCurrentSize() {
        new Attacher()
                .expectationAndReality(this.getPerPage(), this.getData().length);

        assertThat(this.getPerPage()).isEqualTo(this.getData().length);
        return this;
    }
}
