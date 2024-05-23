package PayrollSystem.data;

import java.io.*;

public class EmployeeCollectionIO {
    // Збереження колекції працівників у файл
    public static void saveEmployeeCollection(EmployeeCollection collection, String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(collection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Завантаження колекції працівників з файлу
    public static EmployeeCollection loadEmployeeCollection(String filename) {
        EmployeeCollection collection = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            collection = (EmployeeCollection) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return collection;
    }
}
