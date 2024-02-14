package Models;

import Models.EducationalCommunity.Professor;
import Models.EducationalCommunity.Student;
import Utils.ProperNoun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Course extends ProperNoun {
    String classroom;
    List<Student> students;
    Professor professor;

    public Course(String name, String classroom, List<Student> students, Professor professor) {
        super(name);
        this.classroom = classroom;
        this.students = students;
        this.professor = professor;
    }

    public String getName() {
        return name;
    }

    public String getCourseroom() {
        return classroom;
    }

    public void setCourseroom(String classroom) {
        this.classroom = classroom;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }


    public static List<Course> createCoursees(List<Student> students, List<Professor> professors) {
        Professor professor1=professors.get(0);
        Professor professor2=professors.get(1);

        Student student1 = students.get(0);
        Student student2 = students.get(1);
        Student student3 = students.get(2);
        Student student4 = students.get(3);
        Student student5 = students.get(4);
        Student student6 = students.get(5);


        List<Student> group_students_1 = new ArrayList<>();

        group_students_1.add(student1);
        group_students_1.add(student2);
        group_students_1.add(student3);


        List<Student> group_students_2 = new ArrayList<>();

        group_students_2.add(student4);
        group_students_2.add(student5);
        group_students_2.add(student6);


        List<Student> group_students_3 = new ArrayList<>();

        group_students_3.add(student1);
        group_students_3.add(student2);
        group_students_3.add(student6);


        List<Student> group_students_4 = new ArrayList<>();

        group_students_4.add(student4);
        group_students_4.add(student5);
        group_students_4.add(student3);


        List<Course> courses = new ArrayList<>();

        Course course1 = new Course("Calculus", "A501", group_students_1, professor1);
        Course course2 = new Course("Fisics", "B704", group_students_2, professor2);
        Course course3 = new Course("English", "W210", group_students_3, professor1);
        Course course4 = new Course("IP", "ML603", group_students_4, professor2);

        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);

        return courses;
    }

    public static List<Course> printCourses(University university, Scanner scan){
        List<Course> courses = university.getCourses();

        for (Course course: courses ){
            String name_course = course.getName();
            System.out.println(name_course);
        }
        return courses;

    }

    public static void subMenu(List<Course> courses, University university, Scanner scan){

        boolean course_found = false;
        while (!course_found) {

            System.out.println("Enter the name of the course you want more information about:");
            scan = new Scanner(System.in);
            String entered_course_name = scan.nextLine().trim();

            if (entered_course_name.isEmpty()) {
                System.out.println("Course name cannot be empty.");
                continue;
            }

            if (entered_course_name.matches("\\d+")) {
                System.out.println("Course name cannot consist of only numbers.");
                continue;
            }

            for (Course course: courses ){
                String name_course = course.getName();
                if (name_course.equalsIgnoreCase(entered_course_name)){

                    System.out.println("Assigned classroom: " + course.getCourseroom());

                    String name_professor =course.getProfessor().getName();
                    System.out.println("Course professor name: " + name_professor);

                    List<Student> students = course.getStudents();
                    System.out.println("Students names: ");
                    for (Student student : students){
                        String name_student = student.getName();
                        System.out.println("- "+name_student);
                    }
                    course_found = true;
                    break;
                }
            }
            if (!course_found) {
                System.out.println("Course not found");
            }
        }
    }

    public static void addStudentToCourse(University university, Student student, String entered_course_name) {
        List<Student> students_university = university.getStudents();
        students_university.add(student);

        List<Course> courses = university.getCourses();

        String name_course = null;
        for (Course course : courses) {
            name_course = course.getName();
            if (name_course.equalsIgnoreCase(entered_course_name)) {
                List<Student> students_class = course.getStudents();
                students_class.add(student);
            }
        }

        System.out.println(student.getName()+" has been added to the " + name_course + " class");

    }

    public static void askForCourse(University university, Student student, Scanner scan){


        boolean course_entered = false;

        while (!course_entered) {

            System.out.println("Here is a list of the existing courses at the university:");
            printCourses(university,scan);

            System.out.println("Enter the name of the course you want to add "+ student.getName() + " to:");
            scan = new Scanner(System.in);
            String entered_course_name = scan.nextLine().trim();

            if (entered_course_name.isEmpty()) {
                System.out.println("Course name cannot be empty");
                continue;
            }

            if (entered_course_name.matches("\\d+")) {
                System.out.println("Course name cannot consist of only numbers");
                continue;
            }
            List<Course> courses = university.getCourses();

            for (Course course : courses) {
                String name_course = course.getName();
                if (name_course.equalsIgnoreCase(entered_course_name)) {
                    addStudentToCourse(university,student,entered_course_name);
                    course_entered = true;
                }

            }
            if (!course_entered){
            System.out.println("Course not found");
            }
        }
    }
}
