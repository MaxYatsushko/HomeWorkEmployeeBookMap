import java.util.*;

public class EmployeeBook {

    private final Map<String, Employee> employees;

    public EmployeeBook(Map<String, Employee> employees) {
        this.employees = employees;
    }

    public EmployeeBook(boolean example) {
        if (!example)
            this.employees = new HashMap<String, Employee>();
        else {
            this.employees = new HashMap<String, Employee>();
            employees.put("Ivanov Ivan Ivanovich", new Employee("Ivanov Ivan Ivanovich", 35000, 1));
            employees.put("Petrov Mischele", new Employee("Petrov Mischele", 45000, 1));
            employees.put("Brown Freen Petrovich", new Employee("Brown Freen Petrovich", 55000, 2));
            employees.put("Frey Ivan", new Employee("Frey Ivan", 135000, 4));
            employees.put("Grey White Lee", new Employee("Grey White Lee", 325000, 3));
        }
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

    public Map<String, Employee> getEmployees(){
        return employees;
    }

    public void setSalary(Employee employee, double salary){
        employee.setSalary(salary);
    }

    public void setDepartment(Employee employee, int department){
        employee.setDepartment(department);
    }

    public void printEmployeesByDepartments(){

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
}
