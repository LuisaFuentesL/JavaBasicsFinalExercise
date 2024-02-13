public class Teacher extends ProperNoun{
    double salary;
    String jobModality;

    public Teacher(String name, double salary, String jobModality) {
        super(name);
        this.salary = salary;
        this.jobModality = jobModality;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJobModality() {
        return jobModality;
    }

    public void setJobModality(String jobModality) {
        this.jobModality = jobModality;
    }
}
