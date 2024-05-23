package PayrollSystem.data;

import java.io.Serializable;
import java.util.ArrayList;

public class EmployeeCollection implements Serializable {
    private ArrayList<Employee> employees;

    public EmployeeCollection() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    // Метод для виведення інформації про всіх працівників у базі
    public void printAllEmployees() {
        for (Employee employee : employees) {
            employee.printPaymentDetails();
            System.out.println("---------------------");
        }
    }
}

