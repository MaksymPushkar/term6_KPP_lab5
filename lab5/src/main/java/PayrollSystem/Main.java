package PayrollSystem;

import PayrollSystem.data.*;
import PayrollSystem.ui.MainWindow;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Завантажуємо колекцію працівників з файлу
        EmployeeCollection collection = EmployeeCollectionIO.loadEmployeeCollection("employees.dat");

        // Перевіряємо, чи колекція працівників була завантажена з файлу
        if (collection == null) {
            // Якщо ні, створюємо порожню колекцію
            collection = new EmployeeCollection();
            System.out.println("Колекція працівників не знайдена, створено нову порожню колекцію.");
        } else {
            System.out.println("Колекція працівників завантажена з файлу.");
        }

//        Manager manager1 = new Manager("John Doe", "Manager", 50000, 10000);
//
//        Worker worker1 = new Worker("Jane Smith", "Worker", 30000, 160, 20);
//        Manager manager2 = new Manager("Alice Johnson", "Senior Manager", 60000, 15000);
//        Worker worker2 = new Worker("Bob Brown", "Senior Worker", 35000, 180, 25);
//
//        collection.addEmployee(manager1);
//        collection.addEmployee(worker1);
//        collection.addEmployee(manager2);
//        collection.addEmployee(worker2);
//
//        collection.printAllEmployees();

        // Створюємо новий екземпляр вікна
        MainWindow mainWindow = new MainWindow(collection);
        // Показуємо вікно
        mainWindow.setVisible(true);
    }
}
