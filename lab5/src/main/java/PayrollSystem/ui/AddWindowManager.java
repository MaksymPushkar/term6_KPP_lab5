package PayrollSystem.ui;

import PayrollSystem.data.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWindowManager extends JFrame {
    private JTextArea textAreaName;
    private JTextArea textAreaPosition;
    private JTextArea textAreaBaseSalary;
    private JTextArea textAreaBonus;
    private JTextField textFieldName;
    private JTextField textFieldPosition;
    private JTextField textFieldBaseSalary;
    private JTextField textFieldBonus;
    private JButton btnAdd;
    private JPanel panel1;

    // Посилання на колекцію працівників
    private EmployeeCollection employeeCollection;

    public AddWindowManager(EmployeeCollection employeeCollection) {
        // Виклик конструктора батьківського класу (JFrame)
        super("Add Manager");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);
        setLocationRelativeTo(null);

        // Ініціалізація колекції працівників
        this.employeeCollection = employeeCollection;

        // Додавання обробника подій для кнопки btnAdd
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Отримання значень полів
                String name = textFieldName.getText();
                String position = textFieldPosition.getText();
                double baseSalary = Double.parseDouble(textFieldBaseSalary.getText());
                double bonus = Double.parseDouble(textFieldBonus.getText());

                // Створення об'єкта Manager
                Manager manager = new Manager(name, position, baseSalary, bonus);

                // Додавання об'єкта Manager до колекції працівників
                employeeCollection.addEmployee(manager);
                EmployeeCollectionIO.saveEmployeeCollection(employeeCollection, "employees.dat");

                // Повідомлення про успішне додавання
                JOptionPane.showMessageDialog(null, "Manager added successfully!");

                // Закриття вікна після успішного додавання
                dispose();
            }
        });

        // Встановлення видимості вікна
        setVisible(true);
    }

    public AddWindowManager(Employee employee) {
        // Виклик конструктора батьківського класу (JFrame)
        super("Edit Employee");
        setSize(500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);
        setLocationRelativeTo(null);

        // Заповнення текстових полів даними працівника
        textFieldName.setText(employee.getName());
        textFieldPosition.setText(employee.getPosition());
        textFieldBaseSalary.setText(String.valueOf(employee.getBaseSalary()));

        // Перевірка, чи переданий працівник є менеджером (Manager)
        if (employee instanceof Manager) {
            Manager manager = (Manager) employee;
            textFieldBonus.setText(String.valueOf(manager.getBonus()));
        }

        // Додавання обробника подій для кнопки btnAdd
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Отримання значень полів
                String name = textFieldName.getText();
                String position = textFieldPosition.getText();
                double baseSalary = Double.parseDouble(textFieldBaseSalary.getText());

                // Оновлення даних працівника
                employee.setName(name);
                employee.setPosition(position);
                employee.setBaseSalary(baseSalary);

                // Перевірка, чи переданий працівник є менеджером (Manager)
                if (employee instanceof Manager) {
                    Manager manager = (Manager) employee;
                    double bonus = Double.parseDouble(textFieldBonus.getText());
                    manager.setBonus(bonus);
                }

                // Повідомлення про успішне оновлення
                JOptionPane.showMessageDialog(null, "Employee updated successfully!");

                // Закриття вікна після успішного оновлення
                dispose();
            }
        });

        // Встановлення видимості вікна
        setVisible(true);
    }
}
