package PayrollSystem.ui;

import PayrollSystem.data.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWindowWorker extends JFrame {
    private JTextArea textAreaName;
    private JTextArea textAreaPosition;
    private JTextArea textAreaBaseSalary;
    private JTextArea textAreaHoursWorked;
    private JTextArea textAreaHourlyRate;
    private JTextField textFieldName;
    private JTextField textFieldPosition;
    private JTextField textFieldBaseSalary;
    private JTextField textFieldHoursWorked;
    private JTextField textFieldHourlyRate;
    private JButton btnAdd;
    private JPanel panel1;
    private EmployeeCollection employeeCollection;

    public AddWindowWorker(EmployeeCollection employeeCollection) {
        // Виклик конструктора батьківського класу (JFrame)
        super("Add Worker");
        setSize(500, 800);
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
                int hoursWorked = Integer.parseInt(textFieldHoursWorked.getText());
                double hourlyRate = Double.parseDouble(textFieldHourlyRate.getText());

                // Створення об'єкта Manager
                Worker worker = new Worker(name, position, baseSalary, hoursWorked, hourlyRate);

                // Додавання об'єкта Manager до колекції працівників
                employeeCollection.addEmployee(worker);
                EmployeeCollectionIO.saveEmployeeCollection(employeeCollection, "employees.dat");

                // Повідомлення про успішне додавання
                JOptionPane.showMessageDialog(null, "Worker added successfully!");

                // Закриття вікна після успішного додавання
                dispose();
            }
        });

        // Встановлення видимості вікна
        setVisible(true);
    }

    public AddWindowWorker(Employee employee) {
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

        // Перевірка, чи переданий працівник є робітником (Worker)
        if (employee instanceof Worker) {
            Worker worker = (Worker) employee;
            textFieldHoursWorked.setText(String.valueOf(worker.getHoursWorked()));
            textFieldHourlyRate.setText(String.valueOf(worker.getHourlyRate()));
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

                // Перевірка, чи переданий працівник є робітником (Worker)
                if (employee instanceof Worker) {
                    Worker worker = (Worker) employee;
                    int hoursWorked = Integer.parseInt(textFieldHoursWorked.getText());
                    double hourlyRate = Double.parseDouble(textFieldHourlyRate.getText());
                    worker.setHoursWorked(hoursWorked);
                    worker.setHourlyRate(hourlyRate);
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
