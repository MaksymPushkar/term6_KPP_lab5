package PayrollSystem.data;

import java.io.Serializable;
import java.util.ArrayList;


public abstract class Employee implements Serializable{
    private String name;
    private String position;
    private double baseSalary;

    public Employee(String name, String position, double baseSalary) {
        this.name = name;
        this.position = position;
        this.baseSalary = baseSalary;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    // Метод для розрахунку зарплати, який буде перевизначений в підкласах
    public double calculateSalary() {
        return baseSalary;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Position: " + position + ", Base Salary: " + baseSalary;
    }

    // Метод для формування відомостей на оплату
    public void printPaymentDetails() {
        System.out.println("Name: " + name);
        System.out.println("Position: " + position);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Total Salary: " + calculateSalary());
    }
}
