package Classes;

public class Engineer extends Employee implements Comparable<Engineer> {
    private double workingHours;
    private Grade grade;
    int sort;

    public Engineer(String ID, String name, int age, String grade, double workingHours) {
        super(ID, name, age);
        this.grade = new Grade(grade);
        this.workingHours = workingHours;
        super.setSalary((workingHours * this.grade.PR * 30)*this.grade.TAX);
        switch (grade) {
            case "Manger" -> sort = 1;
            case "Team Leader" -> sort = 2;
            case "Team Member" -> sort = 3;

        }
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }

    public void setGrade(String grade) {
        this.grade = new Grade(grade);
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public double getWorkingHours() {
        return workingHours;
    }

    public String getGrade() {
        return grade.position;
    }

    @Override
    public int compareTo(Engineer otherEngineer) {
        if (sort < otherEngineer.sort) {
            return -1;
        } else if (sort == otherEngineer.sort) {
            if (getSalary() < otherEngineer.getSalary())
                return 1;
            else return -1;
        } else return 1;
    }
}
