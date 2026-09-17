import java.util.Scanner;

public class CanteenOrderingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] menuItems = {
            "Burger",
            "Pizza",
            "Fried Chicken",
            "Spaghetti",
            "French Fries"
        };

        double[] prices = {
            120.00,
            150.00,
            180.00,
            100.00,
            80.00
        };

        int totalQuantity = 0;
        double totalAmount = 0.00;

        char studentStatus = 'N';
        boolean statusRecorded = false;

        System.out.println("========================================");
        System.out.println("          SCHOOL CANTEEN MENU");
        System.out.println("========================================");

        for (int i = 0; i < menuItems.length; i++) {
            System.out.printf("%d. %-20s $%.2f%n",
                    i + 1, menuItems[i], prices[i]);
        }

        System.out.println("========================================");

        char orderAgain = 'Y';

        while (orderAgain == 'Y') {

            System.out.print("\nEnter item number (1-5): ");
            int itemNumber = scanner.nextInt();

            System.out.print("Enter quantity (1-10): ");
            int quantity = scanner.nextInt();

            System.out.print("Are you a student? (Y/N): ");
            char currentStudentStatus =
                    scanner.next().toUpperCase().charAt(0);

            if (itemNumber < 1 || itemNumber > menuItems.length) {
                System.out.println(
                    "Invalid item number. Please choose an item from 1 to 5."
                );
            }

            else if (quantity < 1 || quantity > 10) {
                System.out.println(
                    "Invalid quantity. Quantity must be from 1 to 10."
                );
            }

            // Validate student status
            else if (currentStudentStatus != 'Y'
                    && currentStudentStatus != 'N') {
                System.out.println(
                    "Invalid student status. Please enter Y or N."
                );
            }

            else {
                // Save the customer's status from the valid order.
                if (!statusRecorded) {
                    studentStatus = currentStudentStatus;
                    statusRecorded = true;
                }

                double orderAmount =
                        prices[itemNumber - 1] * quantity;

                totalQuantity += quantity;
                totalAmount += orderAmount;

                System.out.printf(
                    "Order accepted: %d x %s = $%.2f%n",
                    quantity,
                    menuItems[itemNumber - 1],
                    orderAmount
                );
            }

            System.out.print("\nDo you want to order again? (Y/N): ");
            orderAgain = scanner.next().toUpperCase().charAt(0);

            while (orderAgain != 'Y' && orderAgain != 'N') {
                System.out.print(
                    "Invalid choice. Please enter Y or N: "
                );
                orderAgain = scanner.next().toUpperCase().charAt(0);
            }
        }

        double deductionRate;

        if (studentStatus == 'Y' && totalAmount >= 500) {
            deductionRate = 0.15;
        }
        else if (studentStatus == 'Y') {
            deductionRate = 0.10;
        }
        else if (totalAmount >= 500) {
            deductionRate = 0.05;
        }
        else {
            deductionRate = 0.00;
        }

        double totalDeduction = totalAmount * deductionRate;
        double finalAmount = totalAmount - totalDeduction;

        System.out.println("\n========================================");
        System.out.println("           PURCHASE SUMMARY");
        System.out.println("========================================");
        System.out.println(
            "Total quantity of items purchased: " + totalQuantity
        );
        System.out.printf(
            "Total amount before deductions: $%.2f%n",
            totalAmount
        );
        System.out.printf(
            "Total deduction: $%.2f%n",
            totalDeduction
        );
        System.out.printf(
            "Final amount to pay: $%.2f%n",
            finalAmount
        );
        System.out.println("========================================");
        System.out.println("       Thank you for your purchase!");
        System.out.println("========================================");

        scanner.close();
    }
}
```
