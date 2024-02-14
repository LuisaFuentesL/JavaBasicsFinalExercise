import Models.Course;
import Models.EducationalCommunity.Professor;
import Models.EducationalCommunity.Student;
import Models.University;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        University university = University.createUniversity();
        Professor.calculateProfessorsSalary(university);

        Scanner scan = new Scanner(System.in);
        System.out.println("👩🏻‍🎓👨🏻‍🎓 Welcome to Globant University 📚💻");

        while (true) {
            System.out.print("Select the operation you want to perform:\n" +
                    "1. Print all the professors with its data \n" +
                    "2. Print all classes \n" +
                    "3. Create a new student and add it to an existing class \n" +
                    "4. Create a new class and add an existing teacher and students \n" +
                    "5. List all the classes in which a student is included \n" +
                    "6. Exit \n");

            int option = scan.nextInt();

            switch (option) {
                case 1:
                    Professor.printProfessors(university);
                    break;

                case 2:
                    System.out.println("Classes names: " );
                    List<Course> courses = Course.printCourses(university, scan);
                    Course.subMenu(courses, university, scan);
                    break;

                case 3:
                    Student student = Student.askForStudentInfo(scan);
                    Course.askForExistingCourse(university, student, scan);
                    break;

                case 4:
                    Course.askForNewCourse(university, scan);
                    break;

                case 5:
                    Student student_required = Student.askForStudentName(university, scan);
                    Course.listCoursesFromStudent(university, student_required);
                    break;

                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

    }



}