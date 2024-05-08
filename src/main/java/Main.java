import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Service s = new Service();
            s.addStudent(new Student("Krzysztof", 20));
            s.addStudent(new Student("Janusz", 40));

            var students = s.getStudents();
            for(Student current : students) {
              
            }

            boolean running = true;

            while (running) {
                System.out.println("Wybierz:\n1. Dodaj studenta\n2. Wyświtl liste studentów\n3. wyjście");
               
                    option = scanner.nextInt();

            switch(option) {
                case 1:
                    System.out.println("Podaj imię i nazwisko studenta:");
                    String name = scanner.next();
                    System.out.println("Podaj wiek studenta:");
                    int age = scanner.nextInt();
                    s.addStudent(new Student(name, age));
                    break;
                case 2:
                    for(Student student : s.getStudents()) {
                        System.out.println(student.toString());
                    }
                    break;
                case 3:
                    
                default:
                    System.out.println("Niepoprawny wybór, spróbuj ponownie.");
                    break;
            }
        }
     } catch (IOException e) {
        e.printStackTrace();
        }
    }
}