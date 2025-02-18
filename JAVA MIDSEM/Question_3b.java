import java.util.Scanner;

public class Question_3b {
    private static final double KM_TO_MILE = 0.621371;
    private static final double METER_TO_KM = 0.001;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nDistance Converter Menu:");
            System.out.println("1. Meter to Kilometer");
            System.out.println("2. Kilometer to Meter");
            System.out.println("3. Mile to Kilometer");
            System.out.println("4. Kilometer to Mile");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Thank you for using Distance Converter!");
                break;
            }

            System.out.print("Enter the value to convert: ");
            double value = scanner.nextDouble();

            switch (choice) {
                case 1:
                    System.out.printf("%.2f meters = %.2f kilometers%n", 
                        value, meterToKm(value));
                    break;
                case 2:
                    System.out.printf("%.2f kilometers = %.2f meters%n", 
                        value, kmToMeter(value));
                    break;
                case 3:
                    System.out.printf("%.2f miles = %.2f kilometers%n", 
                        value, mileToKm(value));
                    break;
                case 4:
                    System.out.printf("%.2f kilometers = %.2f miles%n", 
                        value, kmToMile(value));
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }

    public static double meterToKm(double meters) {
        return meters * METER_TO_KM;
    }

    public static double kmToMeter(double km) {
        return km / METER_TO_KM;
    }

    public static double mileToKm(double miles) {
        return miles / KM_TO_MILE;
    }

    public static double kmToMile(double km) {
        return km * KM_TO_MILE;
    }
}