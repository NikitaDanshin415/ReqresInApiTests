package api.helpers.spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpec {
    public ResponseSpecification getResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .log(LogDetail.URI)
                .log(LogDetail.BODY)
                .build();
    }

    public ResponseSpecification postResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .log(LogDetail.URI)
                .log(LogDetail.BODY)
                .build();
    }


}
