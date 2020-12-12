public class Manager extends Staff implements ICalculator {
    private String position;
    public Manager (String id, String name, int age, double salaryRate, String startDay, String departmentId, int dayOff, String position) {
        super(id, name, age, salaryRate, startDay, departmentId, dayOff);
        this.position = position;
    }
    public String getPosition () { // Phuong thuc getter: tra ve thuoc tinh doi tuong
        return position;
    }

    @Override
    public double calculateSalary() {
        if (getPosition().equalsIgnoreCase("Business Leader")) {
            return getSalaryRate() * 5000000 + 8000000;
        } else if (getPosition().equalsIgnoreCase("Project Leader")) {
            return getSalaryRate() * 5000000 + 5000000;
        } else if (getPosition().equalsIgnoreCase("Technical Leader")) {
            return getSalaryRate() * 5000000 + 6000000;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return String.format("%-10s%-15s%-10d%-20s%-20s%-15s%-15s%-20s", getId(), getName(), getAge(), getSalaryRate(), getStartDay(), getDepartmentId(), getDayOff(), getPosition());
    }
}