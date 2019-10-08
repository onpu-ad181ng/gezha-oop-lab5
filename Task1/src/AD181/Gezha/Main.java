package AD181.Gezha;

public class Main {
  public static void main(String[] args) {
    Student student1 = new Student("Ross", "Bob", 18, "BS-181", "11037");
    Student student2 = new Student("Cheese", "William", 20, "AA-113", "1498");
    Lecturer lecturer = new Lecturer("Smith", "John", 42, "physics", 2500.0);

    Person[] humans = {student1, student2, lecturer};
    for (Person human : humans) {
      System.out.println(human.printInfo());
    }
  }
}
