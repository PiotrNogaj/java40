import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Service s = new Service();

        boolean running = true;

        while (running) {
            System.out.println("Wybierz:\n1. Dodaj studenta\n2. Wyświetl listę studentów\n3. Wyjście");

            int options = 0;
            try {
                options = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Niepoprawny wybór, spróbuj ponownie.");
                scanner.next(); // czyszczenie błędnego wejścia
                continue;
            }

            switch (options) {
                case 1:
                    System.out.println("Podaj imię studenta:");
                    String name = scanner.next();
                    System.out.println("Podaj nazwisko studenta:");
                    String lastname = scanner.next();
                    System.out.println("Podaj wiek studenta:");
                    int age = 0;
                    try {
                        age = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Niepoprawny wiek, spróbuj ponownie.");
                        scanner.next(); // czyszczenie błędnego wejścia
                        continue;
                    }
                    System.out.println("Podaj datę urodzenia studenta:");
                    String date = scanner.next();
                    try {
                        s.addStudent(new Student(name, lastname, age, date));
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Wystąpił błąd przy dodawaniu studenta.");
                    }
                    break;
                case 2:
                    System.out.println("Lista studentów:");
                    try {
                        for (Student student : s.getStudents()) {
                            System.out.println(student.toString());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Wystąpił błąd przy pobieraniu listy studentów.");
                    }
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Niepoprawny wybór, spróbuj ponownie.");
                    break;
            }
        }
    }
}