package PayrollSystem.data;

public class Worker extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public Worker(String name, String position, double baseSalary, int hoursWorked, double hourlyRate) {
        super(name, position, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    // Геттер та сеттер для hoursWorked
    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    // Геттер та сеттер для hourlyRate
    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return super.getBaseSalary() + (hoursWorked * hourlyRate);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + getName() + '\'' +
                ", position='" + getPosition() + '\'' +
                ", baseSalary=" + getBaseSalary() +
                ", hoursWorked=" + hoursWorked +
                ", hourlyRate=" + hourlyRate +
                '}';
    }
}
