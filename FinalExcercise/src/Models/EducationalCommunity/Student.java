package Models.EducationalCommunity;
import Utils.ProperNoun;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Student extends ProperNoun {
    private static int lastId = 0;
    int id;
    int age;

    public Student(String name, int age){
        super(name);
        this.id = ++lastId;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static List<Student> createStudents() {
        List<Student> students = new ArrayList<>();

        Student student1 = new Student("Laura Martínez", 20);
        Student student2 = new Student("Pedro Coral", 25);
        Student student3 = new Student("Martín Ruiz", 31);
        Student student4 = new Student("Sarah Fuentes", 19);
        Student student5 = new Student("Juan Lora", 23);
        Student student6 = new Student("Paula Picas", 17);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);

        return students;
    }

    public static Student createStudent(String student_name, int student_age){
        Student student = new Student(student_name,student_age);
        System.out.println("The student has been created correctly");

        return student;
    }

    public static Student askForStudentInfo(Scanner scan) {
        Student student = null;
        boolean student_entered = false;

        while (!student_entered) {

            System.out.println("Enter the name of student:");
            scan = new Scanner(System.in);
            String student_name = scan.nextLine().trim();

            if (student_name.isEmpty()) {
                System.out.println("Student name cannot be empty");
                continue;
            }

            if (student_name.matches("\\d+")) {
                System.out.println("Student name cannot consist of only numbers");
                continue;
            }

            while (!student_entered) {
                System.out.println("Enter the age of student:");
                scan = new Scanner(System.in);
                int student_age;

                try {
                    student_age = scan.nextInt();

                    if (student_age <= 0) {
                        System.out.println("Student age must be greater than zero");
                        continue;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Please enter an integer");
                    continue;
                }
                student = createStudent(student_name, student_age);
                student_entered = true;
            }
        }
        return student;
    }
}
