import java.util.ArrayList;
import java.util.Scanner;

class HumanResources {
    static Scanner input;
    static ArrayList<Employee> employees = new ArrayList<>();
    static ArrayList<Manager> managers = new ArrayList<>();
    static ArrayList<Department> departmentList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Human resources");
        input = new Scanner(System.in);
        int choice;
        boolean isExit = true;
        // create department and staff
        Handling.createDepartment();
        Handling.createStaff();
        // Select the functions
        do {
            System.out.println("1. Display all members in the company");
            System.out.println("2. Display departments and total employees");
            System.out.println("3. Display employees by departments");
            System.out.println("4. Enter a new Staff");
            System.out.println("5. Search Employees by name or id");
            System.out.println("6. Search Manager by name or id");
            System.out.println("7. Display salary");
            System.out.println("8. Display salary by order ascending");
            System.out.println("9. Exit");
            System.out.print("Your choice: ");
            choice = Handling.getNum(1, 9, "Your choice: ");
            if (choice == 1) {
                displayStaff();
            } else if (choice == 2) {
                displayDepartment();
            } else if (choice == 3) {
                displayEmployeeByDepartment();
            } else if (choice == 4) {
                addStaff();
            } else if (choice == 5) {
                searchEmployee();
            } else if (choice == 6) {
                searchManager();
            } else if (choice == 7) {
                displaySalaryDescend();
            } else if (choice == 8) {
                displaySalaryAscend();
            } else {
                exit();
                isExit = false;
            }
        } while (isExit);
    }

    // display staffs
    public static void displayStaff() {
        // display managers
        System.out.println("Manager list:");
        System.out.println(String.format(
                "%-10s%-15s%-10s%-20s%-20s%-15s%-15s%-20s",
                "ID",
                "Name",
                "Age",
                "SalaryRate",
                "StartDate",
                "Department",
                "Day Off",
                "Position"));
        for(Manager i : managers) {
            System.out.println(i.toString());
        }
        System.out.println();

        // display employees
        System.out.println("Employee list:");
        System.out.println(String.format(
                "%-10s%-15s%-10s%-20s%-20s%-15s%-15s%-20s",
                "ID",
                "Name",
                "Age",
                "SalaryRate",
                "StartDate",
                "Department",
                "Day Off",
                "Overtime"));
        for(Employee i : employees) {
            System.out.println(i.toString());
        }
        System.out.println("------------------------------------------------------------");
    }

    // display departments
    public static void displayDepartment() {
        System.out.println(String.format(
                "%-20s%-20s%-20s",
                "ID",
                "Department Name",
                "Total"));
        // employees of each department
        int countD1 = 0, countD2 = 0, countD3 = 0;
        for (Employee i : employees) {
            if (i.getDepartmentId().equals("D1")) {
                countD1++;
            }
            else if(i.getDepartmentId().equals("D2")) {
                countD2 ++;
            } else {
                countD3 ++;
            }
        }

        for(Department i : departmentList) {
            if (i.getDepartmentName().equals("Business")) {
                i.setNumberOfStaff(countD1);
            }
            if (i.getDepartmentName().equals("Project")) {
                i.setNumberOfStaff(countD2);
            }
            if (i.getDepartmentName().equals("Technical")) {
                i.setNumberOfStaff(countD3);
            }
        }

        for(Department i : departmentList) {
            System.out.println(String.format(
                    "%-20s%-20s%-20s",
                    i.getDepartmentId(),
                    i.getDepartmentName(),
                    i.getNumberOfStaff()));
        }
        System.out.println("------------------------------------------------------------");
    }

    // display employee by department
    public static void displayEmployeeByDepartment() {
        // display employees of department Business
        System.out.println("Business:");
        System.out.println(Handling.getHeaderDepartment());
        for(Employee e : employees) {
            if(e.getDepartmentId().equals("D1")) {
                System.out.println(String.format(
                        "%-10s%-15s%-10s",
                        e.getId(),
                        e.getName(),
                        e.getAge()));
            }
        }
        System.out.println();

        // display employees of department Project
        System.out.println("Project:");
        System.out.println(Handling.getHeaderDepartment());
        for(Employee e : employees) {
            if(e.getDepartmentId().equals("D2")) {
                System.out.println(String.format(
                        "%-10s%-15s%-10s",
                        e.getId(),
                        e.getName(),
                        e.getAge()));
            }
        }
        System.out.println();

        // display employees of department Technical
        System.out.println("Technical:");
        System.out.println(Handling.getHeaderDepartment());
        for(Employee e : employees) {
            if(e.getDepartmentId().equals("D3")) {
                System.out.println(String.format(
                        "%-10s%-15s%-10s",
                        e.getId(),
                        e.getName(),
                        e.getAge()));
            }
        }
        System.out.println();
        System.out.println("------------------------------------------------------------");
    }

    // add Staffs
    public static void addStaff() {
        input = new Scanner(System.in);
        System.out.print("Employee or Manager (1 = Manager, other = Employee): ");
        int choice = Handling.getNum(Integer.MIN_VALUE, Integer.MAX_VALUE, "Employee or Manager (1 = Manager, other = Employee): ");
        input.nextLine();

        // add id
        System.out.print("Enter ID: ");
        String id;
        boolean isExistId = true;
        /* check id */
        do {
            id = Handling.getString("Enter ID: ");
            if(Handling.checkIdManager(id) && Handling.checkIdEmployee(id)) {
                isExistId = false;
            } else {
                System.out.println("(--- ID already exists, retype ---)");
                System.out.print("Enter ID: ");
            }
        } while (isExistId);

        // add name
        System.out.print("Enter Name: ");
        String name = Handling.getString("Enter Name: ");

        // add age
        System.out.print("Enter Age: ");
        int age = Handling.getNum(0, Integer.MAX_VALUE, "Enter Age: ");

        // add salary
        System.out.print("Enter Salary Rate: ");
        double salaryRate = Handling.getNum(0.0, Double.MAX_VALUE, "Enter Salary Rate: ");
        input.nextLine();

        // add start date
        System.out.print("Enter Start Date: ");
        String startDate = Handling.getString("Enter Start Date: ");

        // add department
        System.out.print("Enter Department (1 = D1, 2 = D2, 3 = D3): ");
        String department;
        int type = Handling.getNum(1, 3, "Enter Department (1 = D1, 2 = D2, 3 = D3): ");
        if (type == 1) {
            department = "D1";
        } else if (type == 2) {
            department = "D2";
        } else {
            department = "D3";
        }

        // add days off
        System.out.print("Enter Day Off: ");
        int dayOff = Handling.getNum(0, 365, "Enter Day Off: ");

        // add employee or manager
        if (choice == 1) {
            String position;
            if (department.equals("D1")) {
                position = "Business Leader";
            } else if (department.equals("D2")) {
                position = "Project Leader";
            } else {
                position = "Technical Leader";
            }
            managers.add(
                    new Manager(id, name, age, salaryRate, startDate, department, dayOff, position));
        } else {
            System.out.print("Enter Overtime: ");
            int overTime = Handling.getNum(0, Integer.MAX_VALUE, "Enter Overtime: ");
            employees.add(
                    new Employee(id, name, age, salaryRate, startDate, department, dayOff, overTime));
        }
        System.out.println();
        System.out.println("Successfully added staff!");
        System.out.println("------------------------------------------------------------");
    }

    // search Employee by name or id
    public static void searchEmployee() {
        System.out.println();
        input = new Scanner(System.in);
        System.out.print("Enter keyword: ");
        String keyword = Handling.getString("Enter keyword: ");

        // create arraylist find
        ArrayList<Employee> foundEmployees = new ArrayList<>();
        for(Employee i : employees) {
            if(i.getId().equalsIgnoreCase(keyword) || i.getName().equalsIgnoreCase(keyword)) {
                foundEmployees.add(i);
            }
        }
        // print data
        if(foundEmployees.isEmpty()) {
            System.out.println("Employee not found.");
            System.out.println("------------------------------------------------------------");
        } else {
            System.out.println("Employees:");
            System.out.println(String.format(
                    "%-10s%-15s%-10s%-20s%-20s%-15s%-15s%-20s",
                    "ID",
                    "Name",
                    "Age",
                    "SalaryRate",
                    "StartDate",
                    "Department",
                    "Day Off",
                    "Overtime"));
            for(Employee i : foundEmployees) {
                System.out.println(i);
                System.out.println("------------------------------------------------------------");
            }
        }
    }

    // search Manager by name or id
    public static void searchManager() {
        System.out.println();
        input = new Scanner(System.in);
        System.out.print("Enter keyword: ");
        String keyword = Handling.getString("Enter keyword: ");

        // create arraylist find
        ArrayList<Manager> foundManager = new ArrayList<>();
        for(Manager i : managers) {
            if(i.getId().equalsIgnoreCase(keyword) || i.getName().equalsIgnoreCase(keyword)) {
                foundManager.add(i);
            }
        }

        // print data
        if(foundManager.isEmpty()) {
            System.out.println("Manager not found.");
            System.out.println("------------------------------------------------------------");
        } else {
            System.out.println("Manager:");
            System.out.println(String.format(
                    "%-10s%-15s%-10s%-20s%-20s%-15s%-15s%-20s",
                    "ID",
                    "Name",
                    "Age",
                    "SalaryRate",
                    "StartDate",
                    "Department",
                    "Day Off",
                    "Position"));
            for(Manager i : foundManager) {
                System.out.println(i);
                System.out.println("------------------------------------------------------------");
            }
        }
    }

    // sort in descending order by salary
    private static int sortDescending(ICalculator a, ICalculator b) {
        return (int) (b.calculateSalary() - a.calculateSalary());
    }

    public static void displaySalaryDescend() {
        System.out.println();
        // display salary manager by id
        System.out.println("Manager salary:");
        Handling.headerSalary();
        managers.sort(HumanResources::sortDescending);
        for (Manager i : managers) {
            System.out.println(String.format("%-10s%-15s%-20s",
                    i.getId().toUpperCase(),
                    i.getName().toUpperCase(),
                    (int) i.calculateSalary()));
        }
        System.out.println();
        // display salary employee by id
        System.out.println("Employee salary:");
        Handling.headerSalary();
        employees.sort(HumanResources::sortDescending);
        for (Employee i: employees) {
            System.out.println(String.format("%-10s%-15s%-20s",
                    i.getId().toUpperCase(),
                    i.getName().toUpperCase(),
                    (int) i.calculateSalary()));
        }
        System.out.println("------------------------------------------------------------");
    }

    // sort in ascending order by salary
    private static int sortAscending(ICalculator a, ICalculator b) {
        return (int) (a.calculateSalary() - b.calculateSalary());
    }

    public static void displaySalaryAscend() {
        System.out.println();
        System.out.println("Manager salary:");
        Handling.headerSalary();
        managers.sort(HumanResources::sortAscending);
        for (Manager i : managers) {
            System.out.println(String.format("%-10s%-15s%-20s",
                    i.getId().toUpperCase(),
                    i.getName().toUpperCase(),
                    (int) i.calculateSalary()));
        }
        System.out.println();
        System.out.println("Employee salary:");
        Handling.headerSalary();
        employees.sort(HumanResources::sortAscending);
        for (Employee i : employees) {
            System.out.println(String.format("%-10s%-15s%-20s",
                    i.getId().toUpperCase(),
                    i.getName().toUpperCase(),
                    (int) i.calculateSalary()));
        }
        System.out.println("------------------------------------------------------------");
    }

    // exit
    public static void exit() {
        System.out.println();
        System.out.println("------------------------------------------------------------");
    }
}