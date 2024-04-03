import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class User {
    String username;
    int balance;

    public User(String username) {
        this.username = username;
        this.balance = loadBalance(); // Load balance from file
    }

    public void updateBalance(int points) {
        this.balance += points;
        saveBalance(); // Save balance to file after each update
    }

    public int getBalance() {
        return this.balance;
    }

    private int loadBalance() {
        try {
            File file = new File(username + "_balance.txt");
            Scanner scanner = new Scanner(file);
            return scanner.nextInt();
        } catch (FileNotFoundException e) {
            return 10; // Default balance if file not found
        }
    }

    private void saveBalance() {
        try {
            PrintWriter writer = new PrintWriter(username + "_balance.txt");
            writer.println(balance);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Could not save balance.");
        }
    }

    
}

class SlotMachine2 {
    private final String[] fruits = {"🍒 Cherry", "🍊 Orange", "🍌 Banana"};

    public void play(User user) {

        if (user.getBalance() < 1) {
            System.out.println("Sorry, you don't have enough balance to play.");
            return;
        }

        System.out.println("Your Balance: " + user.getBalance() + " points");
        System.out.println("Instructions:");
        System.out.println("1. Match three fruits to win points.");
        System.out.println("2. Each game costs 1 point.");
        System.out.println("3. Winnings:");
        System.out.println("   🍒 Three Cherries: 10 points");
        System.out.println("   🍊 Three Oranges: 50 points");
        System.out.println("   🍌 Three Bananas: 1000 points\n");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter to play...");
        scanner.nextLine();

        user.updateBalance(-1); // Deduct 1 point for the game

        int points = 0;

        System.out.println("Spinning...");
        // add spinning sound
        try {
            Thread.sleep(1000); // Initial delay before spinning
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Spin emojis
        for (int i = 0; i < 10; i++) {
            StringBuilder output = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                output.append(fruits[(int) (Math.random() * fruits.length)]).append(" ");
            }
            System.out.print("\r" + output.toString());
            try {
                Thread.sleep(500); // Delay between each spin
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Determine the result
        String[] selectedFruits = new String[3];
        for (int i = 0; i < 3; i++) {
            selectedFruits[i] = fruits[(int) (Math.random() * fruits.length)];
        }

        System.out.println();
        if (selectedFruits[0].equals(selectedFruits[1]) && selectedFruits[1].equals(selectedFruits[2])) {
            if (selectedFruits[0].equals("🍒 Cherry")) {
                points = 10;
            } else if (selectedFruits[0].equals("🍊 Orange")) {
                points = 50;
            } else if (selectedFruits[0].equals("🍌 Banana")) {
                points = 1000;
            }
            System.out.println("Congratulations! You won " + points + " points!");
            // add winning sound
        } else {
            System.out.println("Sorry, try again!");
            // add losing sound
        }

        user.updateBalance(points);
        System.out.println("Your total balance: " + user.getBalance());
    }
}


