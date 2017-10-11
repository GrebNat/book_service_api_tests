package api;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import entities.Book;
import io.restassured.response.ValidatableResponse;

/**
 * Created by Natalia_Grebenshchikova on 10/11/2017.
 */
public class ApiValidation {

  ValidatableResponse validatabe;

  public ApiValidation(ValidatableResponse validatabe) {
    this.validatabe = validatabe;
  }

  public String getId() {
    return validatabe.extract().body().as(Book.class).id;
  }

  public ApiValidation assertBook(Book book) {
    Book bookActual = validatabe.extract().body().as(book.getClass());

    assertThat(bookActual, equalTo(book));

    return this;
  }

  public ApiValidation assertStatus(int status) {
    validatabe.statusCode(status);

    return this;
  }

}
