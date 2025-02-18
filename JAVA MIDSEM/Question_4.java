import java.util.Scanner;

class Employee {
    protected String empName;
    protected int empId;
    protected String address;
    protected String mailId;
    protected String mobileNo;
    protected double basicPay;

    Employee(String empName, int empId, String address, String mailId, String mobileNo, double basicPay) {
        this.empName = empName;
        this.empId = empId;
        this.address = address;
        this.mailId = mailId;
        this.mobileNo = mobileNo;
        this.basicPay = basicPay;
    }

    public void displayPaySlip() {
        double da = basicPay * 0.97;
        double hra = basicPay * 0.10;
        double pf = basicPay * 0.12;
        double staffClubFund = basicPay * 0.001;
        double grossSalary = basicPay + da + hra;
        double netSalary = grossSalary - pf - staffClubFund;

        System.out.println("\n========== PAY SLIP ==========");
        System.out.printf("%-25s %s%n", "Employee Name:", empName);
        System.out.printf("%-25s %d%n", "Employee ID:", empId);
        System.out.printf("%-25s %s%n", "Address:", address);
        System.out.printf("%-25s %s%n", "Mail ID:", mailId);
        System.out.printf("%-25s %s%n", "Mobile No:", mobileNo);
        System.out.printf("%-25s %.2f%n", "Basic Pay:", basicPay);
        System.out.printf("%-25s %.2f%n", "DA (97%):", da);
        System.out.printf("%-25s %.2f%n", "HRA (10%):", hra);
        System.out.printf("%-25s %.2f%n", "PF (12%):", pf);
        System.out.printf("%-25s %.2f%n", "Staff Club Fund (0.1%):", staffClubFund);
        System.out.printf("%-25s %.2f%n", "Gross Salary:", grossSalary);
        System.out.printf("%-25s %.2f%n", "Net Salary:", netSalary);
        System.out.println("============================");
    }
}

class Programmer extends Employee {
    Programmer(String empName, int empId, String address, String mailId, String mobileNo, double basicPay) {
        super(empName, empId, address, mailId, mobileNo, basicPay);
    }
}

class AssistantProfessor extends Employee {
    AssistantProfessor(String empName, int empId, String address, String mailId, String mobileNo, double basicPay) {
        super(empName, empId, address, mailId, mobileNo, basicPay);
    }
}

class AssociateProfessor extends Employee {
    AssociateProfessor(String empName, int empId, String address, String mailId, String mobileNo, double basicPay) {
        super(empName, empId, address, mailId, mobileNo, basicPay);
    }
}

class Professor extends Employee {
    Professor(String empName, int empId, String address, String mailId, String mobileNo, double basicPay) {
        super(empName, empId, address, mailId, mobileNo, basicPay);
    }
}

public class Question_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee employee = null;

        try {
            System.out.println("Enter employee details:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Address: ");
            String address = scanner.nextLine();
            
            System.out.print("Mail ID: ");
            String mailId = scanner.nextLine();
            
            String mobileNo = getValidMobileNumber(scanner);
            
            System.out.print("Basic Pay: ");
            double basicPay = Double.parseDouble(scanner.nextLine());

            System.out.println("\nSelect Employee Type:");
            System.out.println("1. Programmer");
            System.out.println("2. Assistant Professor");
            System.out.println("3. Associate Professor");
            System.out.println("4. Professor");
            System.out.print("Enter choice (1-4): ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: employee = new Programmer(name, id, address, mailId, mobileNo, basicPay); break;
                case 2: employee = new AssistantProfessor(name, id, address, mailId, mobileNo, basicPay); break;
                case 3: employee = new AssociateProfessor(name, id, address, mailId, mobileNo, basicPay); break;
                case 4: employee = new Professor(name, id, address, mailId, mobileNo, basicPay); break;
                default: 
                    System.out.println("Invalid choice! Please select 1-4.");
                    return;
            }

            employee.displayPaySlip();

        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric input!");
        } finally {
            scanner.close();
        }
    }

    private static String getValidMobileNumber(Scanner scanner) {
        while (true) {
            System.out.print("Mobile No: ");
            String mobileNo = scanner.nextLine();
            if (mobileNo.matches("\\d{10}")) {
                return mobileNo;
            }
            System.out.println("Invalid! Enter 10-digit number.");
        }
    }
}
class InputValidator {
    public static boolean isValidName(String name) {
        return name != null && name.matches("[a-zA-Z\\s]+");
    }

    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public static boolean isValidMobile(String mobile) {
        return mobile != null && mobile.matches("\\d{10}");
    }

    public static boolean isValidPay(double pay) {
        return pay > 0;
    }

    public static boolean isValidChoice(int choice) {
        return choice >= 1 && choice <= 4;
    }
}