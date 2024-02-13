import java.util.List;

public class Class extends ProperNoun{
    String classroom;
    List<Student> students;
    Teacher teacher;

    public Class(String name, String classroom, List<Student> students, Teacher teacher) {
        super(name);
        this.classroom = classroom;
        this.students = students;
        this.teacher = teacher;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
