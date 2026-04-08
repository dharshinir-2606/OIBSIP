import java.util.*;

public class ATMApp {

    static Scanner sc = new Scanner(System.in);
    static double balance = 1000; // initial balance
    static String history = "";
    static final int PIN = 1234;

    public static void main(String[] args) {

        System.out.println("🏧 Welcome to ATM Machine");

        if (!checkPin()) {
            System.out.println("❌ Incorrect PIN. Access Denied.");
            return;
        }

        int choice;

        do {
            showMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    showHistory();
                    break;
                case 5:
                    System.out.println("👋 Thank you for using ATM!");
                    break;
                default:
                    System.out.println("⚠️ Invalid choice!");
            }

        } while (choice != 5);
    }

    // 🔐 PIN Verification
    public static boolean checkPin() {
        System.out.print("Enter your PIN: ");
        int enteredPin = sc.nextInt();
        return enteredPin == PIN;
    }

    // 📋 Menu
    public static void showMenu() {
        System.out.println("\n===== ATM MENU =====");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transaction History");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    // 💰 Check Balance
    public static void checkBalance() {
        System.out.println("💰 Current Balance: ₹" + balance);
    }

    // ➕ Deposit
    public static void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();

        if (amount > 0) {
            balance += amount;
            history += "Deposited: ₹" + amount + "\n";
            System.out.println("✅ Amount deposited successfully");
        } else {
            System.out.println("❌ Invalid amount");
        }
    }

    // ➖ Withdraw
    public static void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        if (amount > balance) {
            System.out.println("❌ Insufficient balance");
        } else if (amount <= 0) {
            System.out.println("❌ Invalid amount");
        } else {
            balance -= amount;
            history += "Withdrawn: ₹" + amount + "\n";
            System.out.println("✅ Please collect your cash");
        }
    }

    // 📜 Transaction History
    public static void showHistory() {
        if (history.isEmpty()) {
            System.out.println("📭 No transactions yet");
        } else {
            System.out.println("📜 Transaction History:");
            System.out.println(history);
        }
    }
}