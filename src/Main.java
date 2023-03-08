public class Main {
    private static final Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("Ivanov Ivan Ivanovich", 35000, 1);
        employees[2] = new Employee("Petrov Mischele", 45000, 1);
        employees[3] = new Employee("Brown Freen Petrovich", 55000, 2);
        employees[4] = new Employee("Frey Ivan", 135000, 4);
        employees[5] = new Employee("Grey White Lee", 325000, 3);

        printEmployees();
        printSalary();
        printEmployeeWithMinSalary();
        printEmployeeWithMaxSalary();
        printAverageSalary();
        printFullNames();

        //middle task
        printAverageSalary(1);
        //indexSalary(50);
        printEmployees();
        printEmployeeWithMaxSalaryByDep(1);
        printEmployeeWithMinSalaryByDep(6);
        indexSalary(50, 1);
        printEmployees();
        printFullNames(1);

        printEmployeeWithSalary(true, 56000);

        //hard task
        System.out.println("Демонстрация задач \"Очень сложно\"");
        EmployeeBook employeeBook = new EmployeeBook(10);
        employeeBook.addEmployee(employees[0]);
        employeeBook.addEmployee(employees[1]);
        employeeBook.addEmployee(employees[2]);
        employeeBook.addEmployee(employees[3]);
        employeeBook.addEmployee(employees[4]);
        employeeBook.addEmployee(employees[5]);
        employeeBook.printEmployeesByDepartments();

        employeeBook.removeEmployee(employees[3]);
        employeeBook.removeEmployee(employees[0]);
        employeeBook.removeEmployee(employees[1]);
        employeeBook.printEmployeesByDepartments();

    }

    private static void printEmployees(){
        for (Employee employee : employees){
            if(employee == null)
                continue;
            System.out.println(employee);
        }
    }

    private static void printSalary(){
        double totalSalary = 0;
        for (Employee employee : employees){
            if(employee == null)
                continue;
            totalSalary += employee.getSalary();
        }
        System.out.println("Зарплата всех сотрудников составляет: " + totalSalary);
    }

    private static void printEmployeeWithMinSalary(){
        double minSalary = Double.MAX_VALUE;
        Employee employeeWithMinSalary = null;
        for (Employee employee : employees){
            if(employee != null && employee.getSalary() < minSalary) {
                employeeWithMinSalary = employee;
                minSalary = employeeWithMinSalary.getSalary();
            }
        }
        if (employeeWithMinSalary != null)
            System.out.println("Сотрудник с наименьшей зарплатой: " + employeeWithMinSalary);
        else
            System.out.println("Сотрудники отсутствуют");
    }

    private static void printEmployeeWithMaxSalary(){
        double maxSalary = Double.MIN_VALUE;
        Employee employeeWithMaxSalary = null;
        for (Employee employee : employees){
            if(employee != null && employee.getSalary() > maxSalary) {
                employeeWithMaxSalary = employee;
                maxSalary = employeeWithMaxSalary.getSalary();
            }
        }
        if (employeeWithMaxSalary != null)
            System.out.println("Сотрудник с наибольшей зарплатой: " + employeeWithMaxSalary);
        else
            System.out.println("Сотрудники отсутствуют");
    }

    private static void printAverageSalary(){
        int numberEmployee = 0;
        double averageSalary = 0;
        for (Employee employee : employees){
            if(employee != null) {
                numberEmployee++;
                averageSalary += employee.getSalary();
            }
        }
        averageSalary = numberEmployee > 0 ? averageSalary / numberEmployee : 0;
        System.out.println("Средняя зарплата составляет:" + averageSalary);
    }

    private static void printFullNames(){
        for (Employee employee : employees)
            if(employee != null)
                System.out.println(employee.getFullName());
    }

    private static void printFullNames(int department){
        System.out.println("Сотрудники отдела:" + department);
        for (Employee employee : employees)
            if(employee != null && employee.getDepartment() == department)
                System.out.println(employee.getFullName());
    }

    private static void indexSalary(double persent)
    {
        boolean flag = false;

        if (persent < 1 || persent > 100) {
            throw new RuntimeException("Процент введене не корректно. Процент должен быть в диапозоне 1 - 100");
        }
        for (Employee employee : employees){
            if(employee != null) {
                double tempSalary = employee.getSalary();
                employee.setSalary(tempSalary + tempSalary * (persent / 100));
                flag = true;
            }
        }

        if (flag)
            System.out.println("По всей компании зарплата проиденксирована на " + persent + "процентов");
    }

    //полиморфизм
    private static void indexSalary(double persent, int department)
    {
        boolean flag = false;

        if (persent < 1 || persent > 100) {
            throw new RuntimeException("Процент введене не корректно. Процент должен быть в диапозоне 1 - 100");
        }
        for (Employee employee : employees){
            if(employee != null && employee.getDepartment() == department) {
                double tempSalary = employee.getSalary();
                employee.setSalary(tempSalary + tempSalary * (persent / 100));
                flag = true;
            }
        }
        if (flag)
            System.out.println("Для отдела:" + department + " зарплата проиденксирована на " + persent + "процентов");
    }

    private static void printEmployeeWithMinSalaryByDep(int department){
        double minSalary = Double.MAX_VALUE;
        Employee employeeWithMinSalary = null;
        for (Employee employee : employees){
            if(employee != null && employee.getSalary() < minSalary && employee.getDepartment() == department) {
                employeeWithMinSalary = employee;
                minSalary = employeeWithMinSalary.getSalary();
            }
        }
        if (employeeWithMinSalary != null)
            System.out.println("Сотрудник  отделе:" + department + " с наименьшей зарплатой: " + employeeWithMinSalary);
        else
            System.out.println("Сотрудники в отделе:" + department + " отсутствуют");
    }

    private static void printEmployeeWithMaxSalaryByDep(int department){
        double maxSalary = Double.MIN_VALUE;
        Employee employeeWithMaxSalary = null;
        for (Employee employee : employees){
            if(employee != null && employee.getSalary() > maxSalary && employee.getDepartment() == department) {
                employeeWithMaxSalary = employee;
                maxSalary = employeeWithMaxSalary.getSalary();
            }
        }
        if (employeeWithMaxSalary != null)
            System.out.println("Сотрудник  отделе:" + department + " с наибольшей зарплатой: " + employeeWithMaxSalary);
        else
            System.out.println("Сотрудники в отделе:" + department + " отсутствуют");
    }

    private static void printAverageSalary(int department){
        int numberEmployee = 0;
        double averageSalary = 0;
        for (Employee employee : employees){
            if(employee != null && employee.getDepartment() == department) {
                numberEmployee++;
                averageSalary += employee.getSalary();
            }
        }

        averageSalary = numberEmployee > 0 ? averageSalary / numberEmployee : 0;
        System.out.println("Средняя зарплата в отделе:" + department + " составляет:" + averageSalary);
    }

    //lessSalary - флаг, false - >= salary, true - < salary
    private static void printEmployeeWithSalary(boolean lessSalary, double salary) {

        System.out.println("Сотрудники с заплатой " + (lessSalary ? "меньше " : "больше или равно ") + salary);
        for (Employee employee : employees) {
            if (employee != null && ((lessSalary && employee.getSalary() < salary) || (!lessSalary && employee.getSalary() >= salary))) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }
}