package Models.EducationalCommunity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Models.Course;
import Models.University;
import Utils.ProperNoun;

public class Professor extends ProperNoun {
    double salary;
    String jobModality;
    double activeHoursWeek;

    int experienceYears;

    static final String PART_TIME = "Part Time";
    static final String FULL_TIME = "Full Time";

    static final double BASE_SALARY = 1800000;


    public Professor(String name, double salary, String jobModality, double activeHoursWeek, int experienceYears) {
        super(name);
        this.salary = salary;
        this.jobModality = jobModality;
        this.activeHoursWeek = activeHoursWeek;
        this.experienceYears = experienceYears;
    }

    public String getName() {
        return name;
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

    public double getActiveHoursWeek() {
        return activeHoursWeek;
    }

    public void setActiveHours(double activeHoursWeek) {
        this.activeHoursWeek = activeHoursWeek;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public static List<Professor> createProfessors() {
        List<Professor> professors = new ArrayList<>();

        Professor professor1 = new Professor("Francisco Pérez",BASE_SALARY,PART_TIME,25,0);
        Professor professor2 = new Professor("Marina Ladino",BASE_SALARY,FULL_TIME,45,5);

        professors.add(professor1);
        professors.add(professor2);

        return professors;
    }

    public static void calculateProfessorsSalary(University university){
        List<Professor> professors= university.getProfessors();
        for (Professor professor: professors){
            String jobModality_professor = professor.getJobModality();
            if (jobModality_professor.equals("Part Time")){
                double hours_week_professor = professor.getActiveHoursWeek();
                double new_salary = professor.getSalary()* (hours_week_professor*0.05);
                professor.setSalary(new_salary);
            }
            else{
                double experience_years_professor = professor.getExperienceYears();
                double new_salary = professor.getSalary() * (1 + 0.1 * experience_years_professor);
                professor.setSalary(new_salary);
            }
        }
    }

    public static void printProfessors(University university){
        System.out.println("Here is a list of the existing professors at the university:");

        List<Professor> professors= university.getProfessors();
        for (Professor professor: professors){

            String name_professor = professor.getName();
            String jobModality_professor = professor.getJobModality();
            double salary_professor = professor.getSalary();
            double hours_week_professor = professor.getActiveHoursWeek();
            int experience_years_professor = professor.getExperienceYears();

            System.out.println("Name: " + name_professor + ", Job Modality: " + jobModality_professor
                    + ", Salary: " + salary_professor + ", Active hours per week: " + hours_week_professor
                    + ", Experience years: " + experience_years_professor);


        }

    }

    public static Professor askForProfessor(University university, String entered_course_name, Scanner scan) {
        boolean professor_entered = false;
        Professor professor_rta = null;

        while (!professor_entered) {
            printProfessors(university);

            System.out.println("Enter the name of the professor you want to add to teach " + entered_course_name+":");
            scan = new Scanner(System.in);
            String entered_professor_name = scan.nextLine().trim();

            if (entered_professor_name.isEmpty()) {
                System.out.println("Professor name cannot be empty");
                continue;
            }

            if (entered_professor_name.matches("\\d+")) {
                System.out.println("Professor name cannot consist of only numbers");
                continue;
            }

            List<Professor> professors = university.getProfessors();

            for (Professor professor : professors) {
                String name_professor = professor.getName();
                if (name_professor.equalsIgnoreCase(entered_professor_name)) {
                    professor_rta = professor;
                    professor_entered = true;
                }

            }
            if (!professor_entered) {
                System.out.println("Professor not found");
            }
        }
        return professor_rta;
    }

}
