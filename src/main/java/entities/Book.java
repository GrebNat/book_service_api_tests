package entities;

/**
 * Created by Natalia_Grebenshchikova on 10/3/2017.
 */
public class Book implements Cloneable{

  public static final Book test_book = new Book("Karlson", "Astret", "1952", "1234567890123",
      new Publisher("Piter", "St.Petersburg"));

  public Book() {
  }

  public Book(String title, String author, String year, String isbn,
      Publisher publisher) {
    this.title = title;
    this.author = author;
    this.year = year;
    this.isbn = isbn;
    this.publisher = publisher;
  }

  public String id;

  public String title;

  public String author;

  public String year;

  public String isbn;

  public Publisher publisher;

  public Book setTitleOut(String title) {
    this.title = title;
    return this;
  }

  public Book setAuthorOut(String author) {
    this.author = author;
    return this;
  }

  public Book setYearOut(String year) {
    this.year = year;
    return this;
  }

  public Book setIsbnOut(String isbn) {
    this.isbn = isbn;
    return this;
  }

  public Book setPublisherOut(Publisher publisher) {
    this.publisher = publisher;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Book book = (Book) o;

    if (title != null ? !title.equals(book.title) : book.title != null) {
      return false;
    }
    if (author != null ? !author.equals(book.author) : book.author != null) {
      return false;
    }
    if (year != null ? !year.equals(book.year) : book.year != null) {
      return false;
    }
    if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null) {
      return false;
    }
    return publisher != null ? publisher.equals(book.publisher) : book.publisher == null;
  }

  @Override
  public int hashCode() {
    int result = title != null ? title.hashCode() : 0;
    result = 31 * result + (author != null ? author.hashCode() : 0);
    result = 31 * result + (year != null ? year.hashCode() : 0);
    result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
    result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Book{" +
        "id='" + id + '\'' +
        ", title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", year='" + year + '\'' +
        ", isbn='" + isbn + '\'' +
        ", publisher=" + publisher +
        '}';
  }

  @Override
  public Book clone() throws CloneNotSupportedException {
    return (Book) super.clone();
  }
}
