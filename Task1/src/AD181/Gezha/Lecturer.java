package AD181.Gezha;

public class Lecturer extends Person {
  private String department = "";
  private double salary = 0.0;

  public Lecturer(String surname, String name, int age, String department, double salary) {
    super(surname, name, age);
    this.department = department;
    this.salary = salary;
  }

  @Override
  public String printInfo() {
    return "Lecturer of " + this.getDepartment() + " department " + this.getSurname() + " " +
           this.getName() + ", age: " + this.getAge() +
           ". Salary: " + this.getSalary();
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }
}
