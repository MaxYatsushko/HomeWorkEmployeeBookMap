import java.util.Objects;

public class Employee {

    private final String fullName;
    private double salary;
    private int department;



    public Employee(String fullName, double salary, int department) {
        this.fullName   = fullName;
        this.salary     = salary;
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public String toString(){
        return "Сотрудник:" + fullName + " в отделе:" + department + " получает зп:" + salary;
    }

    public String toStringWithoutDepartment(){
        return "Сотрудник:" + fullName + " получает зп:" + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && department == employee.department && id == employee.id && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, salary, department);
    }
}
