import static api.BookApi.createBook;
import static api.BookApi.getBook;
import static api.BookApi.updateBook;
import static entities.Book.test_book;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;

import entities.Book;
import org.testng.annotations.Test;

/**
 * Created by Natalia_Grebenshchikova on 10/11/2017.
 */
public class CreateBookTest {

  @Test
  public static void endToEndBookTest() throws CloneNotSupportedException {
    String id;
    Book book = test_book.clone();

    id = createBook(book).getId();
    getBook(id)
        .assertStatus(SC_OK)
        .assertBook(book);

    book.setTitleOut("new_book_title");
    updateBook(id, book)
        .assertStatus(SC_CREATED)
        .assertBook(book);
  }

  @Test(dataProviderClass = DataProvider.class, dataProvider = "negative_book")
  public static void createBookNegativeTest(Book book, int status) {
    createBook(book).assertStatus(status);
  }

}
