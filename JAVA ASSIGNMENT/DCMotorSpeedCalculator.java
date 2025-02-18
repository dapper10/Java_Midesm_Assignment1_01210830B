/*
APPIAH GIDEON
01210830B
JAVA ASSIGNMENT
*/


import java.util.Scanner;

public class DCMotorSpeedCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input validation for voltage
        double voltage = getValidInput(scanner, "Enter the input voltage (V): ", 0, Double.MAX_VALUE);
        
        // Input validation for back EMF
        double backEMF = getValidInput(scanner, "Enter the back EMF (V): ", 0, voltage);
        
        // Input validation for motor constant
        double motorConstant = getValidInput(scanner, "Enter the motor constant (V/RPM): ", Double.MIN_NORMAL, Double.MAX_VALUE);
        
        // Calculate speed in RPM
        double speedRPM = calculateSpeed(voltage, backEMF, motorConstant);
        
        // Output the calculated speed
        System.out.printf("The speed of the DC motor is %.2f RPM%n", speedRPM);
        
        scanner.close();
    }

    // Method to calculate speed
    private static double calculateSpeed(double voltage, double backEMF, double motorConstant) {
        return (voltage - backEMF) / motorConstant;
    }

    // Helper method for input validation
    private static double getValidInput(Scanner scanner, String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Double.parseDouble(scanner.nextLine());
                if (value < min || value > max) {
                    System.out.println("Invalid input. Must be between " + min + " and " + max + ".");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}
