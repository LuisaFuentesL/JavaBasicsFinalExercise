package Models;

import Models.EducationalCommunity.Professor;
import Models.EducationalCommunity.Student;

import java.util.List;

public class University {
    List<Professor> professors;
    List<Student> students;
    List<Course> courses;

    public University(List<Professor>professors, List<Student> students, List<Course> courses) {
        this.professors = professors;
        this.students = students;
        this.courses = courses;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public static University createUniversity(){
        List<Student> students = Student.createStudents();
        List<Professor> professors = Professor.createProfessors();
        List<Course> courses = Course.createCourses(students, professors);

        return new University(professors,students,courses);
    }
}
