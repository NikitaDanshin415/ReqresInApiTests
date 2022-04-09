package api.models.response;

import api.helpers.Attacher;
import io.qameta.allure.Step;
import lombok.Data;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Data
public class UserModelPostResponse {
    private int id;
    private String name;
    private String job;
    private Calendar createdAt;

    @Step("name должен быть равен {name}")
    public UserModelPostResponse nameIsEqual(String name) {
        new Attacher()
                .expectationAndReality(name, this.name);

        assertThat(this.name).isEqualTo(name);
        return this;
    }

    @Step("job должен быть равен {job}")
    public UserModelPostResponse jobIsEqual(String job) {
        new Attacher()
                .expectationAndReality(job, this.job);

        assertThat(this.job).isEqualTo(job);
        return this;
    }

}
