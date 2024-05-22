public class Student {

    private String Name;
    private String Lastname;
    private int Age;
    private String Date;

    public Student(String name, String lastname, int age, String date) {
        Name = name;
        Lastname = lastname;
        Age = age;
        Date = date;
    }

    public String GetName() {
        return Name;
    }

    public String GetLastname() {
        return Lastname;
    }

    public int GetAge() {
        return Age;
    }

    public String GetDate() {
        return Date;
    }

    @Override
    public String toString() {
        return Name + " " + Lastname + " " + Age + " " + Date;
    }

    public static Student Parse(String str) {
        String[] data = str.split(" ");
        if (data.length != 4) {
            return new Student("Parse Error", "Parse Error", -1, "Parse Error");
        }
        return new Student(data[0], data[1], Integer.parseInt(data[2]), data[3]);
    }
}