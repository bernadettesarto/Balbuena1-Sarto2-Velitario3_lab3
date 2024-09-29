import java.util.Scanner;

public class Clock {

    // Unified method for conversions
    public static double convertTime(int value, String fromUnit, String toUnit) {
        switch (fromUnit + " to " + toUnit) {
            case "Seconds to Minutes":
                return value / 60.0;
            case "Seconds to Hours":
                return value / 3600.0;
            case "Minutes to Seconds":
                return value * 60;
            case "Minutes to Hours":
                return value / 60.0;
            case "Hours to Seconds":
                return value * 3600;
            case "Hours to Minutes":
                return value * 60;
            default:
                throw new IllegalArgumentException("Invalid conversion");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueConversion = "Y";  // Initialize with "Y" to ensure the loop starts

        String[] options = {
            "Seconds to Minutes", "Seconds to Hours", 
            "Minutes to Seconds", "Minutes to Hours", 
            "Hours to Seconds", "Hours to Minutes"
        };

        do {
            // Display conversion options
            for (int i = 0; i < options.length; i++) {
                System.out.println("[" + (i + 1) + "] " + options[i]);
            }
            System.out.print("Choose the Conversion: ");
            int choice = scanner.nextInt();

            if (choice < 1 || choice > options.length) {
                System.out.println("Invalid choice!");
                continue;
            }

            System.out.print("Enter the Value: ");
            int value = scanner.nextInt();

            String conversion = options[choice - 1];
            String[] units = conversion.split(" to ");
            String fromUnit = units[0];
            String toUnit = units[1];

            // Perform the conversion
            double result = convertTime(value, fromUnit, toUnit);
            System.out.println(fromUnit + " to " + toUnit + ": " + result);

            // Ask user if they want to convert again
            System.out.print("Do you want to convert time? (Y/N): ");
            continueConversion = scanner.next();
        } while (continueConversion.equalsIgnoreCase("Y"));

        scanner.close();
    }
}