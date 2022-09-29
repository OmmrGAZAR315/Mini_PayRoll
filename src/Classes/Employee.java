package Classes;

public abstract class Employee {
    private String ID;
    private String name;
    private int age;
    private double salary;

    public Employee(String ID, String name, int age) {
        this.ID = ID;
        this.name = name;
        this.age = age;
    }

    public Employee(String ID, String name, int age, double salary) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
