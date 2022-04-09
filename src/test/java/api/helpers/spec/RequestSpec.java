package api.helpers.spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
    public RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .build();
    }


    public RequestSpecification postRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setContentType(ContentType.JSON)
                .log(LogDetail.URI)
                .log(LogDetail.BODY)
                .build();
    }



}
