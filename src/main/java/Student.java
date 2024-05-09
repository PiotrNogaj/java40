public class Student {

  private String Name;
  private String Lastname;
  private int Age;

  public Student(String name,String lastname, int age) {
    Name = name;
    Lastname = lastname;
    Age = age;
  }

  public String GetName() {return Name;}
  public String GetLastname() {return Lastname;} 
  public int GetAge() {return Age;}

  public String toString() {
    return Name + " " + Lastname + " " + Integer.toString(Age);
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if(data.length != 3) 
      return new Student("Parse Error", "Parse Error", -1);
    return new Student(data[0], data[1], Integer.parseInt(data[2]));
  }
}