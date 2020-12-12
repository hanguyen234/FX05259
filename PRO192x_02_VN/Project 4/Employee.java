public class Employee extends Staff implements ICalculator {
    private int overtime;
    public Employee(String id, String name, int age, double salaryRate, String startDay,
                    String departmentId, int dayOff, int overtime) {
        super(id, name, age, salaryRate, startDay, departmentId, dayOff);
        this.overtime = overtime;
    }
    public int getOverTime () {
        return overtime;
    }

    @Override
    public double calculateSalary() {
        return getSalaryRate() *3000000 + overtime*200000;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-15s%-10d%-20s%-20s%-15s%-15d%-20d", getId(), getName(), getAge(), getSalaryRate(), getStartDay(), getDepartmentId(), getDayOff(), getOverTime());
    }

}