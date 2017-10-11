package api;

import static java.text.MessageFormat.format;

import com.google.gson.Gson;
import entities.Book;
import io.restassured.response.ValidatableResponse;

/**
 * Created by Natalia_Grebenshchikova on 10/11/2017.
 */
public class BookApi {

  public final static String BOOK_URI = "/book";
  public final static String BOOK_ALL_URI = "/book/getAll";

  public static ApiValidation createBook(Book book) {
    ValidatableResponse vr = new BaseApi().post(BOOK_URI, new Gson().toJson(book));

    return new ApiValidation(vr);
  }

  public static ApiValidation getBook(String id) {
    ValidatableResponse vr = new BaseApi().get(format("{0}/{1}", BOOK_URI, id));
    return new ApiValidation(vr);
  }

  public static ApiValidation updateBook(String id, Book book) {
    ValidatableResponse vr = new BaseApi()
        .put(format("{0}/{1}", BOOK_URI, id), new Gson().toJson(book));
    return new ApiValidation(vr);
  }

  public static ApiValidation getAllBook() {
    ValidatableResponse vr = new BaseApi().get(BOOK_ALL_URI);
    return new ApiValidation(vr);
  }

}
