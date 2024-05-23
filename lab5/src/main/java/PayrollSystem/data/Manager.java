package PayrollSystem.data;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, String position, double baseSalary, double bonus) {
        super(name, position, baseSalary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return super.getBaseSalary() + bonus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + getName() + '\'' +
                ", position='" + getPosition() + '\'' +
                ", baseSalary=" + getBaseSalary() +
                ", bonus=" + bonus +
                '}';
    }
}
