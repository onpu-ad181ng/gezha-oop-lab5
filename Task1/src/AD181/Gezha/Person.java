package AD181.Gezha;

public class Person {
  private String surname = "";
  private String name = "";
  private int age = 0;

  public Person(String surname, String name, int age) {
    this.surname = surname;
    this.name = name;
    this.age = age;
  }

  public String printInfo() {
    return "Person " + this.getSurname() + " " +
           this.getName() + ", age: " + this.getAge();
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getSurname() {
    return surname;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }
}
