package Classes;

public class Trainee extends Employee {
    String university;
    double GPA;
    int academicYear;

    public Trainee(String ID, String name, int age, double salary, String university, double GPA, int academicYear) {
        super(ID, name, age, salary);
        this.university = university;
        this.GPA = GPA;
        this.academicYear = academicYear;
    }

    public String getUniversity() {
        return university;
    }

    public double getGPA() {
        return GPA;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }
}
