import java.util.Collection;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Service {

    public void addStudent(Student student) throws IOException {
        var f = new FileWriter("db.txt", true);
        var b = new BufferedWriter(f);
        b.append(student.toString());
        b.newLine();
        b.close();
    }

    public Collection<Student> getStudents() throws IOException {
        var ret = new ArrayList<Student>();
        var f = new FileReader("db.txt");
        var reader = new BufferedReader(f);
        String line;

        while ((line = reader.readLine()) != null) {
            Student student = Student.Parse(line);
            if (!student.GetName().equals("Parse Error")) {
                ret.add(student);
            }
        }

        reader.close();
        return ret;
    }

    public Student findStudentByName(String name) {
        try {
            for (Student student : getStudents()) {
                if (student.GetName().equalsIgnoreCase(name)) {
                    return student;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Wystąpił błąd przy pobieraniu listy studentów.");
        }
        return null;
    }
}
