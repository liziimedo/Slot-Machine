import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("🎰 Slot Machine 🎰");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        User user = new User(username);
        SlotMachine2 slotMachine2 = new SlotMachine2();

        while (true) {
            slotMachine2.play(user);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }
        System.out.println("Thanks for playing!");
    }
}
