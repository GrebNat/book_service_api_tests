package entities;

/**
 * Created by Natalia_Grebenshchikova on 10/4/2017.
 */
public class Publisher {

  public Publisher(String name, String city) {
    this.name = name;
    this.city = city;
  }

  public Publisher() {
  }


  public String name;

  public String city;

  @Override
  public String toString() {
    return "Publisher{" +
        "name='" + name + '\'' +
        ", city='" + city + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Publisher publisher = (Publisher) o;

    if (name != null ? !name.equals(publisher.name) : publisher.name != null) {
      return false;
    }
    return city != null ? city.equals(publisher.city) : publisher.city == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (city != null ? city.hashCode() : 0);
    return result;
  }
}

