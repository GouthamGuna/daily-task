package main.general;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class DayMinusOne {

    public static void main(String[] args) {
        String domainName = "pearl";
        String locationId = "5";
        String startDate = "22-12-2023";
        String endDate = "22-12-2023";
        String bankBranchId = "1";

        List<String> dates = new ArrayList<>();
        dates.add(startDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for (int i = 0; i < 90; i++) {
            try {
                LocalDate date = LocalDate.parse(dates.get(i), formatter);
                double result = processDate(domainName, locationId, date.toString(), bankBranchId);
                if (result == 0.00) {
                    LocalDate previousDate = date.minusDays(1);
                    dates.add(previousDate.format(formatter));
                } else {
                    System.out.println("Result for " + date + ": " + result);
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format: " + dates.get(i));
            }
        }
    }

    private static double processDate(String domainName, String locationId, String date, String bankBranchId) {
        // Implement your logic to process the date and return the result
        // For this example, we'll return a random value
        System.out.println("date = " + date);
        return Math.random() * 100;
    }
}

/**
 * import java.time.LocalDate;
 * import java.time.format.DateTimeFormatter;
 * <p>
 * public class AvailabilityChecker {
 * public static void main(String[] args) {
 * String inputDate = "22-12-2023"; // Input date in "dd-MM-yyyy" format
 * double totalAvailability = 0.0;
 * <p>
 * // Parse the input date
 * LocalDate currentDate = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
 * <p>
 * // Check availability for the previous 90 days
 * for (int i = 0; i < 90; i++) {
 * String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
 * double availability = checkDataIsAvailableOrNot(formattedDate);
 * totalAvailability += availability;
 * <p>
 * // If availability is not 0.00, break the loop
 * if (availability != 0.00) {
 * System.out.println("Availability is not 0.00 for date: " + formattedDate);
 * break;
 * }
 * <p>
 * // Move to the previous day
 * currentDate = currentDate.minusDays(1);
 * }
 * <p>
 * System.out.println("Total availability score for the previous 90 days: " + totalAvailability);
 * }
 * <p>
 * // Simulate the availability check (replace with your actual logic)
 * static double checkDataIsAvailableOrNot(String inputDate) {
 * // Implement your logic to process the date and return the result
 * // For demonstration, returning a random value between 0 and 100
 * return Math.random() * 100;
 * }
 * }
 * <p>
 * Notes:
 * Replace the checkDataIsAvailableOrNot method with your actual logic to calculate availability.
 * The code above assumes that the input date is in the format “dd-MM-yyyy”. Adjust the format as needed.
 * The loop breaks if availability is not 0.00 for any day.
 * Adjust the availability calculation based on your specific requirements.
 */