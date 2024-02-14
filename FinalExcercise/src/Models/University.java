package Models;

import Models.EducationalCommunity.Professor;
import Models.EducationalCommunity.Student;
import Utils.ProperNoun;

import java.util.List;

public class University extends ProperNoun {
    List<Professor> professors;
    List<Student> students;
    List<Course> courses;

    public University(String name, List<Professor>professors, List<Student> students, List<Course> courses) {
        super(name);
        this.professors = professors;
        this.students = students;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public static University createUniversity(){
        List<Student> students = Student.createStudents();
        List<Professor> professors = Professor.createProfessors();
        List<Course> courses = Course.createCoursees(students, professors);

        return new University("Globant Models.University",professors,students,courses);
    }
}
