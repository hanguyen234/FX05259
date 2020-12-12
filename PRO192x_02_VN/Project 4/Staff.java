public abstract class Staff {
    private String id;
    private String name;
    private int age;
    private double salaryRate;
    private String startDay;
    private String departmentId;
    private int dayOff;

    protected Staff (String id, String name, int age, double salaryRate, String startDay, String departmentId, int dayOff) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salaryRate = salaryRate;
        this.startDay = startDay;
        this.departmentId = departmentId;
        this.dayOff = dayOff;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getSalaryRate() {
        return salaryRate;
    }
    public String getStartDay () {
        return startDay;
    }
    public String getDepartmentId() {
        return departmentId;
    }
    public int getDayOff ()  {
        return dayOff;
    }

    public abstract String toString();
}
