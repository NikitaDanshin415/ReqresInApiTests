package api.models.request;

import lombok.Data;

@Data
public class UserModelPostRequest {
    public UserModelPostRequest(String name, String job) {
        this.name = name;
        this.job = job;
    }

    private String name;
    private String job;
}
