package PayrollSystem.ui;

import PayrollSystem.data.EmployeeCollection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWindow extends JFrame {
    private JComboBox<String> comboBox1;
    private JTextArea textFieldChoiceEmployeeType;
    private JPanel panel1;
    private JButton btnNext;

    public AddWindow(EmployeeCollection employeeCollection) {
        // Виклик конструктора батьківського класу (JFrame)
        super("Add Employee");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);
        setLocationRelativeTo(null);

        // Ініціалізація компонентів і налаштування інтерфейсу

        // Додавання обробника подій для кнопки btnNext
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Отримання вибраного елемента з comboBox1
                String selectedType = (String) comboBox1.getSelectedItem();

                // Перевірка, який тип був вибраний і відкриття відповідного вікна
                if ("Manager".equals(selectedType)) {
                    AddWindowManager managerWindow = new AddWindowManager(employeeCollection);
                    managerWindow.setVisible(true);
                } else if ("Worker".equals(selectedType)) {
                    AddWindowWorker workerWindow = new AddWindowWorker(employeeCollection);
                    workerWindow.setVisible(true);
                }

                // Закриття вікна
                dispose();
            }
        });

        // Встановлення видимості вікна
        setVisible(true);
    }
}
