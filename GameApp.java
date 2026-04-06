import java.util.*;

public class GameApp {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("🎯 Welcome to Smart Number Guessing Game!");

        boolean playAgain = true;

        while (playAgain) {
            playGame();

            System.out.print("\nDo you want to play again? (yes/no): ");
            String choice = sc.next().toLowerCase();

            playAgain = choice.equals("yes");
        }

        System.out.println("Thanks for playing! 👋");
    }

    public static void playGame() {
        Random rand = new Random();
        int number = rand.nextInt(100) + 1;

        int attemptsLeft = 5;
        int score = 100;

        System.out.println("\nGuess a number between 1 and 100");
        System.out.println("You have " + attemptsLeft + " attempts!");

        while (attemptsLeft > 0) {
            System.out.print("Enter your guess: ");
            int guess = sc.nextInt();

            if (guess == number) {
                System.out.println("🎉 Correct! You win!");
                System.out.println("⭐ Your score: " + score);
                return;
            }

            if (guess < number) {
                System.out.println("📉 Too low!");
            } else {
                System.out.println("📈 Too high!");
            }

            attemptsLeft--;
            score -= 20;

            System.out.println("Attempts left: " + attemptsLeft);
        }

        System.out.println("❌ You lost! The number was: " + number);
    }
}
