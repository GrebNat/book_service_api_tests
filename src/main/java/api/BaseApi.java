package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

/**
 * Created by Natalia_Grebenshchikova on 10/11/2017.
 */
public class BaseApi {

  RequestSpecBuilder requestSpecBuilder;
  RequestSpecification requestSpecification;

  public BaseApi() {
    requestSpecBuilder = new RequestSpecBuilder()
        .setContentType(ContentType.JSON)
        .setBaseUri("http://localhost:22365");
    requestSpecification = RestAssured.given(requestSpecBuilder.build());
  }

  public ValidatableResponse post(String uri, String resource) {
    return requestSpecification
        .body(resource)
        .post(uri)
        .peek()
        .then();
  }

  public ValidatableResponse put(String uri, String newResource) {
    return requestSpecification
        .body(newResource)
        .put(uri)
        .peek()
        .then();
  }

  public ValidatableResponse get(String uri) {
    return requestSpecification
        .get(uri)
        .peek()
        .then();
  }

}
