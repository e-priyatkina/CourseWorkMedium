public class Employee {
    private final String fullName;
    private int department;
    private float salary;
    private final int id;
    private static int counter = 1;


    public Employee (String fullName, int department, int salary) {
        this.id = counter++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public float getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String toString() {
        return this.id + " ФИО: " + this.fullName + ", отдел: " + this.department + ", зарплата: " +
                this.salary;
    }
}
