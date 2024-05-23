package PayrollSystem.ui;

import PayrollSystem.data.*;

import javax.swing.*;
import java.util.ArrayList;

public class MainWindow extends JFrame {
    private JPanel panel1;
    private JList<Employee> list1; // Оновлено тип JList для працівників
    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnShowPayroll;
    private JButton btnUpdate;
    private JButton btnEdit;

    private EmployeeCollection employeeCollection; // Додано посилання на EmployeeCollection

    public MainWindow(EmployeeCollection employeeCollection) {
        super("Payroll System");
        setSize(1000, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);
        setLocationRelativeTo(null);

        this.employeeCollection = employeeCollection; // Ініціалізуємо посилання на EmployeeCollection

        // Оновлення JList з працівниками при створенні вікна
        updateEmployeeList();

        btnAdd.addActionListener(e -> openAddWindow());
        btnUpdate.addActionListener(e -> updateEmployeeList());
        btnEdit.addActionListener(e -> editSelectedEmployee());
        btnDelete.addActionListener(e -> deleteSelectedEmployee());
        btnShowPayroll.addActionListener(e -> showPayroll());
    }

    private void openAddWindow() {
        AddWindow addWindow = new AddWindow(employeeCollection);
        addWindow.setVisible(true);
    }

    // Метод для оновлення списку працівників у JList
    private void updateEmployeeList() {
        ArrayList<Employee> employees = employeeCollection.getEmployees();
        Employee[] employeeArray = new Employee[employees.size()];
        employees.toArray(employeeArray);
        list1.setListData(employeeArray);
        // Зберегти колекцію у файл
        EmployeeCollectionIO.saveEmployeeCollection(employeeCollection, "employees.dat");
    }

    private void editSelectedEmployee() {
        Employee selectedEmployee = list1.getSelectedValue();
        if (selectedEmployee != null) {
            if (selectedEmployee instanceof Manager) {
                AddWindowManager addWindowManager = new AddWindowManager(selectedEmployee);
                addWindowManager.setVisible(true);
            } else if (selectedEmployee instanceof Worker) {
                AddWindowWorker addWindowWorker = new AddWindowWorker(selectedEmployee);
                addWindowWorker.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select an employee to edit.");
        }
    }

    // Метод для видалення виділеного об'єкта Employee з JList та колекції працівників
    private void deleteSelectedEmployee() {
        Employee selectedEmployee = list1.getSelectedValue();
        if (selectedEmployee != null) {
            // Видалення об'єкта з колекції працівників
            employeeCollection.removeEmployee(selectedEmployee);
            // Оновлення JList після видалення
            updateEmployeeList();
        } else {
            JOptionPane.showMessageDialog(null, "Please select an employee to delete.");
        }
    }

    // Додамо метод для відображення розрахунку зарплати
    private void showPayroll() {
        StringBuilder payrollInfo = new StringBuilder();

        ArrayList<Employee> employees = employeeCollection.getEmployees();
        for (Employee employee : employees) {
            payrollInfo.append("Name: ").append(employee.getName()).append("\n");
            payrollInfo.append("Position: ").append(employee.getPosition()).append("\n");
            payrollInfo.append("Base Salary: ").append(employee.getBaseSalary()).append("\n");
            payrollInfo.append("Total Salary: ").append(employee.calculateSalary()).append("\n");
            payrollInfo.append("---------------------\n");
        }

        JOptionPane.showMessageDialog(null, payrollInfo.toString(), "Payroll Information", JOptionPane.INFORMATION_MESSAGE);
    }

}
