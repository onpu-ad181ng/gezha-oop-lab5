package AD181.Gezha;

public class Student extends Person {
  private String group = "";
  private String studentID = "";

  public Student(String surname, String name, int age, String group, String studentID) {
    super(surname, name, age);
    this.group = group;
    this.studentID = studentID;
  }

  @Override
  public String printInfo() {
    return "Student of group " + this.getGroup() + " " + this.getSurname() + " " +
           this.getName() + ", age: " + this.getAge() +
           ". Student ID: " + this.getStudentID();
  }

  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public String getStudentID() {
    return studentID;
  }

  public void setStudentID(String studentID) {
    this.studentID = studentID;
  }
}
