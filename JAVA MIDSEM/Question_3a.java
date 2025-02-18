import java.util.Scanner;

public class Question_3a {
    private static final double USD_TO_GHS = 12.50;
    private static final double EUR_TO_GHS = 13.50;
    private static final double YEN_TO_GHS = 0.084;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nCurrency Converter Menu:");
            System.out.println("1. Dollar to GHS");
            System.out.println("2. GHS to Dollar");
            System.out.println("3. Euro to GHS");
            System.out.println("4. GHS to Euro");
            System.out.println("5. Yen to GHS");
            System.out.println("6. GHS to Yen");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");

            int choice = scanner.nextInt();

            if (choice == 7) {
                System.out.println("Thank you for using the converter!");
                break;
            }

            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();

            switch (choice) {
                case 1 -> System.out.printf("%.2f USD = %.2f GHS%n", amount, amount * USD_TO_GHS);
                case 2 -> System.out.printf("%.2f GHS = %.2f USD%n", amount, amount / USD_TO_GHS);
                case 3 -> System.out.printf("%.2f EUR = %.2f GHS%n", amount, amount * EUR_TO_GHS);
                case 4 -> System.out.printf("%.2f GHS = %.2f EUR%n", amount, amount / EUR_TO_GHS);
                case 5 -> System.out.printf("%.2f YEN = %.2f GHS%n", amount, amount * YEN_TO_GHS);
                case 6 -> System.out.printf("%.2f GHS = %.2f YEN%n", amount, amount / YEN_TO_GHS);
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }
}