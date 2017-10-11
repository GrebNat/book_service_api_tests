import static entities.Book.test_book;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;

/**
 * Created by Natalia_Grebenshchikova on 10/11/2017.
 */
public class DataProvider {

  @org.testng.annotations.DataProvider(name="negative_book")
  public static Object[][] negativeBookData() throws CloneNotSupportedException {
    return new Object[][]{
      {test_book.clone().setIsbnOut("000"), SC_BAD_REQUEST},
      {test_book.clone().setYearOut("000"), SC_BAD_REQUEST}
    };
  }

}
