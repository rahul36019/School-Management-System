import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to XYZ School Management System!");

        // Create teachers
        Teacher lizzy = new Teacher(1, "Lizzy", 500);
        Teacher mellisa = new Teacher(2, "Mellisa", 700);
        Teacher vanderhorn = new Teacher(3, "Vanderhorn", 600);
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(lizzy);
        teacherList.add(mellisa);
        teacherList.add(vanderhorn);

        // Create students
        Student tamasha = new Student(1, "Tamasha", 4);
        Student rakshith = new Student(2, "Rakshith Vasudev", 12);
        Student rabbi = new Student(3, "Rabbi", 5);
        List<Student> studentList = new ArrayList<>();
        studentList.add(tamasha);
        studentList.add(rakshith);
        studentList.add(rabbi);

        // Create school
        School ghs = new School(teacherList, studentList);

        // Main loop
        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Interact with Teachers");
            System.out.println("2. Interact with Students");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    interactWithTeachers(scanner, ghs);
                    break;
                case 2:
                    interactWithStudents(scanner, ghs);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }

    private static void interactWithTeachers(Scanner scanner, School school) {
        System.out.println("\nTeachers List:");
        for (Teacher teacher : school.getTeachers()) {
            System.out.println(teacher.getName());
        }
        System.out.println("Enter teacher's name to view details:");
        String teacherName = scanner.nextLine();
        Teacher selectedTeacher = null;
        for (Teacher teacher : school.getTeachers()) {
            if (teacher.getName().equalsIgnoreCase(teacherName)) {
                selectedTeacher = teacher;
                break;
            }
        }
        if (selectedTeacher != null) {
            System.out.println(selectedTeacher);
        } else {
            System.out.println("Teacher not found!");
        }
    }

    private static void interactWithStudents(Scanner scanner, School school) {
        System.out.println("\nStudents List:");
        for (Student student : school.getStudents()) {
            System.out.println(student.getName());
        }
        System.out.println("Enter student's name to view details:");
        String studentName = scanner.nextLine();
        Student selectedStudent = null;
        for (Student student : school.getStudents()) {
            if (student.getName().equalsIgnoreCase(studentName)) {
                selectedStudent = student;
                break;
            }
        }
        if (selectedStudent != null) {
            System.out.println(selectedStudent);
            System.out.println("1. Pay Fees");
            System.out.println("2. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            switch (choice) {
                case 1:
                    System.out.println("Enter amount to pay:");
                    int amount = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    selectedStudent.payFees(amount);
                    System.out.println("Fees paid successfully.");
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("Student not found!");
        }
    }
}
