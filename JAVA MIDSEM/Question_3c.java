import java.util.Scanner;

public class Question_3c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTime Converter Menu:");
            System.out.println("1. Hours to Minutes and Seconds");
            System.out.println("2. Minutes to Hours and Seconds");
            System.out.println("3. Seconds to Hours and Minutes");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    convertHoursToMinutesSeconds(scanner);
                    break;
                case 2:
                    convertMinutesToHoursSeconds(scanner);
                    break;
                case 3:
                    convertSecondsToHoursMinutes(scanner);
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Convert hours to minutes and seconds
    private static void convertHoursToMinutesSeconds(Scanner scanner) {
        System.out.print("Enter hours: ");
        int hours = scanner.nextInt();
        int minutes = hours * 60;
        int seconds = minutes * 60;
        System.out.println(hours + " hours is " + minutes + " minutes and " + seconds + " seconds.");
    }

    // Convert minutes to hours and seconds
    private static void convertMinutesToHoursSeconds(Scanner scanner) {
        System.out.print("Enter minutes: ");
        int minutes = scanner.nextInt();
        int hours = minutes / 60;
        int seconds = (minutes % 60) * 60;
        System.out.println(minutes + " minutes is " + hours + " hours and " + seconds + " seconds.");
    }

    // Convert seconds to hours and minutes
    private static void convertSecondsToHoursMinutes(Scanner scanner) {
        System.out.print("Enter seconds: ");
        int seconds = scanner.nextInt();
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        System.out.println(seconds + " seconds is " + hours + " hours and " + minutes + " minutes.");
    }
}