import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Slot Machine Game!");
        System.out.println("Instructions:");
        System.out.println("1. You start with a balance of 10 points.");
        System.out.println("2. Each game costs 1 point.");
        System.out.println("3. Match three fruits to win points.");
        System.out.println("   - Three Cherries: 10 points");
        System.out.println("   - Three Oranges: 50 points");
        System.out.println("   - Three Bananas: 1000 points\n");

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        User user = new User(username);
        SlotMachine slotMachine = new SlotMachine();

        while (true) {
            slotMachine.play(user);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }
        System.out.println("Thanks for playing!");
    }
}