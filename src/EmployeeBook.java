import java.util.*;

public class EmployeeBook {

    private final Map<String,Employee> employees;

    public EmployeeBook(Map<String, Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee){
        if(employees.containsKey(employee.getFullName())){
            System.out.println("Сотрудник уже добавлен");
            return;
        }
        employees.put(employee.getFullName(), employee);
    }

    public void removeEmployee(Employee employee){

        if(employees.containsKey(employee.getFullName())){
            System.out.println("Сотрудник отсутствует");
            return;
        }

        employees.remove(employee.getFullName());
    }

    public Employee getEmployee(String fullName){
        return employees.get(fullName);
    }

    public void setSalary(Employee employee, double salary){
        employee.setSalary(salary);
    }

    public void setDepartment(Employee employee, int department){
        employee.setDepartment(department);
    }

    public void printEmployeesByDepartments(){

        Set<Integer> numberDepartments = new HashSet<>();
        boolean isFindDepartment;
        int count = 0;

        Map<Integer, List<Employee>> employeeDepartment = new HashMap<>();

        //получаем существующие отделы по списку сотрудников
        for (Employee employee : employees.values()) {

            if (employeeDepartment.containsKey(employee.getDepartment()))
                employeeDepartment.get(employee.getDepartment()).add(employee);
            else {
                List<Employee> listEmployee = new ArrayList<>();
                listEmployee.add(employee);
                employeeDepartment.put(employee.getDepartment(), listEmployee);
            }
        }

        for (Integer department : employeeDepartment.keySet())
            System.out.println("Сотрудники отдела " + department + "\\n" + employeeDepartment.get(department));

    }

    private boolean isFindDepartment(int[] numberDepartments, int department){
        for (int i = 0; i < numberDepartments.length; i++)
            if (numberDepartments[i] == department)
                return true;
        return false;
    }
}
