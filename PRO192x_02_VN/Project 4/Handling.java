public class Handling {
    /* create department */
    public static void createDepartment() {
        HumanResources.departmentList.add(new Department("D1", "Business", 0));
        HumanResources.departmentList.add(new Department("D2", "Project", 0));
        HumanResources.departmentList.add(new Department("D3", "Technical", 0));
    }

    /* create staff */
    public static void createStaff() {
        /*create employees*/
        HumanResources.employees.add(new Employee("E1", "Employee1", 24,1.5, "01/03/2020", "D1", 2, 15 ));
        HumanResources.employees.add(new Employee("E2", "Employee2", 25,1.7, "02/03/2020", "D2", 3, 18 ));
        HumanResources.employees.add(new Employee("E3", "Employee3", 26,1.9, "03/03/2020", "D3", 4, 12 ));

        /* create managers*/
        HumanResources.managers.add(new Manager("M1", "Manager1", 34,2.0, "04/03/2020", "D1", 1, "Business Leader" ));
        HumanResources.managers.add(new Manager("M2", "Manager2", 35,2.1, "05/03/2020", "D2", 2, "Project Leader" ));
        HumanResources.managers.add(new Manager("M3", "Manager3", 36,2.5, "06/03/2020", "D3", 3, "Technical Leader" ));
    }

    /* print employee by department */
    public static String getHeaderDepartment() {
        return String.format(
                "%-10s%-15s%-10s",
                "ID",
                "Name",
                "Age");
    }

    /* check id */
    static boolean checkIdEmployee (String id) {
        for(Employee e : HumanResources.employees) {
            if(e.getId().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }

    static boolean checkIdManager (String id) {
        for(Manager e : HumanResources.managers) {
            if (e.getId().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }

    /* print header salary */
    public static void headerSalary() {
        System.out.println(String.format("%-10s%-15s%-20s",
                "ID",
                "Name",
                "Salary"));
    }

    /* check integer */
    public static int getNum(int min, int max, String message) {
        boolean isNum = true;
        int num = 0;
        do {
            if (HumanResources.input.hasNextInt()) {
                num = HumanResources.input.nextInt();
                if (num >= min && num <= max) {
                    isNum = false;
                } else {
                    System.out.println("(---It's outside the range from " + min + " to " + max + " , retype---)");
                    System.out.print(message);
                }
            } else {
                HumanResources.input.next();
                System.out.println("(---Not a Number or Integer, retype---)");
                System.out.print(message);
            }
        } while (isNum);
        return num;
    }

    /* check double */
    public static double getNum(double min, double max, String message) {
        boolean isNum = true;
        double num = 0;
        do {
            if (HumanResources.input.hasNextDouble()) {
                num = HumanResources.input.nextDouble();
                if (num >= min && num <= max) {
                    isNum = false;
                } else {
                    System.out.println("(---It's outside the range from " + min + " to " + max + " , retype---)");
                    System.out.print(message);
                }
            } else {
                HumanResources.input.next();
                System.out.println("(---Not a Number, retype---)");
                System.out.print(message);
            }
        } while (isNum);
        return num;
    }

    /* check String input*/
    public static String getString(String message) {
        String s = HumanResources.input.nextLine();
        while(s.trim().equals("")) {
            System.out.println("(--- Cannot be null! Enter again: ---)");
            System.out.print(message);
            s = HumanResources.input.nextLine();
        }
        return s.trim();
    }
}