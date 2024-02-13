public class Student extends ProperNoun{
    String id;
    int age;

    public Student(String name, String id, int age){
        super(name);
        this.id = id;
        this.age = age;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
