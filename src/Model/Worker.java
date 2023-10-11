package Model;
import java.time.LocalDate;

public class Worker {
    private String id;
    private String name;
    private int age;
    private double salary;
    private String workLocation;
    private LocalDate lastSalaryAdjustmentDate;

    public Worker(String id, String name, int age, double salary, String workLocation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocation = workLocation;
        this.lastSalaryAdjustmentDate = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public LocalDate getLastSalaryAdjustmentDate() {
        return lastSalaryAdjustmentDate;
    }

    public void setLastSalaryAdjustmentDate(LocalDate lastSalaryAdjustmentDate) {
        this.lastSalaryAdjustmentDate = lastSalaryAdjustmentDate;
    }

   

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Age: " + age + " | Salary: " + salary + " | Location: " + workLocation
                + " | Last Adjustment Date: " + lastSalaryAdjustmentDate;
    }
}
