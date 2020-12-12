public class Department {
    private String departmentId ;
    private String departmentName;
    private int numberOfStaff;
    public Department (String departmentId, String departmentName, int numberOfStaff) { //
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.numberOfStaff = numberOfStaff;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getNumberOfStaff(){
        return numberOfStaff;
    }

    public void setNumberOfStaff (int numberOfStaff) {
        this.numberOfStaff = numberOfStaff;
    }

    public String toString () {
        return String.format("%-20s%-20s%-20d", getDepartmentId(), getDepartmentName(), getNumberOfStaff());
    }
}