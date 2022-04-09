package api.helpers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification {
    public RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .log(LogDetail.URI)
                .log(LogDetail.BODY)
                .build();
    }

    public ResponseSpecification getResponseSpecification() {
        return new ResponseSpecBuilder()
                .log(LogDetail.URI)
                .log(LogDetail.BODY)
                .expectStatusCode(200)
                .build();
    }
}
