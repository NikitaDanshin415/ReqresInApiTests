package api.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.qameta.allure.Step;

import java.net.URL;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserData {
    int id;

    String email;

    @JsonProperty("first_name")
    String firstName;

    @JsonProperty("last_name")
    String lastName;

    URL avatar;

    @Step("Id должен быть равен {id}")
    public UserData idIsEqualTo(int id){
        assertThat(this.getId()).isEqualTo(id);
        return this;
    }

    @Step("Email должен быть равен {email}")
    public UserData emailIsEqualTo(String email){
        assertThat(this.getEmail()).isEqualTo(email);
        return this;
    }

    @Step("FirstName должен быть равен {firstName}")
    public UserData firstNameIsEqualTo(String firstName){
        assertThat(this.getFirstName()).isEqualTo(firstName);
        return this;
    }

    @Step("LastName должен быть равен {lastName}")
    public UserData lastNameIsEqualTo(String last_name){
        assertThat(this.getLastName()).isEqualTo(last_name);
        return this;
    }

    @Step("Ссылка на аватарку должна быть равна {avatarUrl}")
    public UserData avatarUrlIsEqualTo(String avatarUrl){
        assertThat(this.getAvatar().toString()).isEqualTo(avatarUrl);
        return this;
    }

}
