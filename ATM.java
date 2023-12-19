import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private User currentUser;

    public void start() {
        System.out.println("Welcome to the ATM!");

        // Simulate user authentication
        authenticateUser();

        if (currentUser != null) {
            showMenu();
        }

    }  

        private void authenticateUser() {
            Scanner scanner = new Scanner(System.in);
    
            System.out.print("Enter user ID: ");
            String userId = scanner.nextLine();
    
            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();
    
            // Simulate user authentication (replace with actual logic)
            if (isValidUser(userId, pin)) {
                currentUser = new User(userId, pin);
                System.out.println("Authentication successful. Welcome, " + userId + "!");
            } else {
                System.out.println("Invalid user ID or PIN. Exiting...");
            }
        }
      
    
        private boolean isValidUser(String userId, String pin) {
            // Replace this with actual user validation logic
            return "12345".equals(userId) && "6789".equals(pin);
        }
    
        private void showMenu() {
            Scanner scanner = new Scanner(System.in);
            int choice;
    
            do {
                System.out.println("\n1. Transactions History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
    
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
    
                switch (choice) {
                    case 1:
                        displayTransactionHistory();
                        break;
                    case 2:
                        performWithdrawal();
                        break;
                    case 3:
                        performDeposit();
                        break;
                    case 4:
                        performTransfer();
                        break;
                    case 5:
                        System.out.println("Exiting. Thank you for using the ATM!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 5);
        }
    
        private void displayTransactionHistory() {
            ArrayList<Transaction> transactions = currentUser.getTransactionHistory();
            System.out.println("\nTransaction History:");
    
            for (Transaction transaction : transactions) {
                System.out.println(transaction.getType() + ": $" + transaction.getAmount());
            }
        }
    
        private void performWithdrawal() {
            Scanner scanner = new Scanner(System.in);
    
            System.out.print("Enter withdrawal amount: $");
            double amount = scanner.nextDouble();
    
            currentUser.withdraw(amount);
        }
    
        private void performDeposit() {
            Scanner scanner = new Scanner(System.in);
    
            System.out.print("Enter deposit amount: $");
            double amount = scanner.nextDouble();
    
            currentUser.deposit(amount);
        }
    
        private void performTransfer() {
            Scanner scanner = new Scanner(System.in);
    
            System.out.print("Enter recipient's user ID: ");
            String recipientId = scanner.nextLine();
    
            // Simulate recipient validation (replace with actual logic)
            User recipient = new User(recipientId, "");
            
            if (isValidRecipient(recipient)) {
                System.out.print("Enter transfer amount: $");
                double amount = scanner.nextDouble();
    
                currentUser.transfer(recipient, amount);
            } else {
                System.out.println("Invalid recipient. Please try again.");
            }
        }
    
        private boolean isValidRecipient(User recipient) {
            // Replace this with actual recipient validation logic
            return true;
        }
    }

