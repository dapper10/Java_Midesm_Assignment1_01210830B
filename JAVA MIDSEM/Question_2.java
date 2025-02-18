import java.util.Scanner;

class ElectricityBill {
    // Attributes
    private String consumerNo;
    private String consumerName;
    private int prevReading;
    private int currReading;
    private String connectionType;

    // Constructor
    public ElectricityBill(String consumerNo, String consumerName, int prevReading, int currReading, String connectionType) {
        this.consumerNo = consumerNo;
        this.consumerName = consumerName;
        this.prevReading = prevReading;
        this.currReading = currReading;
        this.connectionType = connectionType;
    }

    // Method to calculate the bill
    public double calculateBill() {
        int unitsConsumed = currReading - prevReading;
        double billAmount = 0;

        if (connectionType.equalsIgnoreCase("domestic")) {
            // Domestic tariff calculation
            if (unitsConsumed <= 100) {
                billAmount = unitsConsumed * 1.0;
            } else if (unitsConsumed <= 200) {
                billAmount = 100 * 1.0 + (unitsConsumed - 100) * 2.5;
            } else if (unitsConsumed <= 500) {
                billAmount = 100 * 1.0 + 100 * 2.5 + (unitsConsumed - 200) * 4.0;
            } else {
                billAmount = 100 * 1.0 + 100 * 2.5 + 300 * 4.0 + (unitsConsumed - 500) * 6.0;
            }
        } else if (connectionType.equalsIgnoreCase("commercial")) {
            // Commercial tariff calculation
            if (unitsConsumed <= 100) {
                billAmount = unitsConsumed * 2.0;
            } else if (unitsConsumed <= 200) {
                billAmount = 100 * 2.0 + (unitsConsumed - 100) * 4.5;
            } else if (unitsConsumed <= 500) {
                billAmount = 100 * 2.0 + 100 * 4.5 + (unitsConsumed - 200) * 6.0;
            } else {
                billAmount = 100 * 2.0 + 100 * 4.5 + 300 * 6.0 + (unitsConsumed - 500) * 7.0;
            }
        } else {
            System.out.println("Invalid connection type. Please enter 'domestic' or 'commercial'.");
        }

        return billAmount;
    }

    // Method to display the bill
    public void displayBill() {
        System.out.println("\nElectricity Bill");
        System.out.println("-------------------------");
        System.out.println("Consumer No: " + consumerNo);
        System.out.println("Consumer Name: " + consumerName);
        System.out.println("Previous Reading: " + prevReading);
        System.out.println("Current Reading: " + currReading);
        System.out.println("Units Consumed: " + (currReading - prevReading));
        System.out.printf("Bill Amount: Gh. %.2f\n", calculateBill());
        System.out.println("-------------------------");
    }
}

public class Question_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input details
        System.out.println("Enter Consumer No: ");
        String consumerNo = scanner.nextLine();

        System.out.println("Enter Consumer Name: ");
        String consumerName = scanner.nextLine();

        System.out.println("Enter Previous Month Reading: ");
        int prevReading = scanner.nextInt();

        System.out.println("Enter Current Month Reading: ");
        int currReading = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character

        System.out.println("Enter Connection Type (domestic/commercial): ");
        String connectionType = scanner.nextLine();

        // Create ElectricityBill instance
        ElectricityBill bill = new ElectricityBill(consumerNo, consumerName, prevReading, currReading, connectionType);

        // Display the bill
        bill.displayBill();

        scanner.close();
    }
}
