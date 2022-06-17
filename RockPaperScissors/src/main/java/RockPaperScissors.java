import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    static int ties;
    static int wins;
    static int losses;
    static int rounds;

    public static void main(String[] args) {

        boolean again = false;
        Scanner sc = new Scanner(System.in);

        do {
            ties = 0;
            wins = 0;
            losses=0;
            rounds = 0;
            run();
            String input;
            do {
                System.out.println("Would you like to play again? (Yes/No)");
                input = sc.nextLine().toLowerCase();
                if (input.equals("yes")) {
                    System.out.println("Here we go again....\n");
                    again = true;
                    break;
                } else if (input.equals("no")) {
                    System.out.println("Thanks for playing!\nExiting.....");
                    again = false;
                    break;
                }
                else {
                    System.out.println("Invalid entry.");
                }
            } while (!input.equals("no") || !input.equals("yes"));
        } while (again);

    }
    private static String printResult(int player, int computer) {
        if (player == computer) {
            ties++;
            return "It's a Tie!";
        } else if (((player == 0 && computer == 2) || (player == 1 && computer == 0)) || (player == 2 && computer == 1)) {
            wins++;
            return "You Win!";
        } else {
            losses++;
            return "You lose, better luck next time!";
        }
    }

    private static void run(){
        Random rand = new Random();
        String[] options = new String[]{"Rock","Paper","Scissors"};
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("How many rounds do you want to play?");
            rounds = sc.nextInt();
            if (rounds<1 || rounds>10) {
                System.out.println("Not within the range of 1-10. please try again.");
            }
        } while (rounds<1 || rounds>10);

        for (int i =0; i<rounds;i++) {
            int players_choice;
            do {
                System.out.println("For this round, what would you like to choose:\n\n" +
                        "  1: Rock\n" +
                        "  2: Paper\n" +
                        "  3: Scissors\n");
                players_choice = sc.nextInt()-1;
                if (players_choice<0 || players_choice>2) {
                    System.out.println("Not a valid option. Please try again.\n");
                }
            } while (players_choice<0 || players_choice>2);

            int computers_choice = rand.nextInt(3);

            System.out.println("You chose: " + options[players_choice]);
            System.out.println("The Computer chose: "+options[computers_choice]);
            printResult(players_choice,computers_choice);
        }
        System.out.println("You had "+wins+" wins, "+losses+" losses and tied "+ties+" time(times) against the computer.");
        if (wins>losses) {
            System.out.println("Congratulations! YOU WON!");
        } else if (losses> wins) {
            System.out.println("Unlucky! The Computer won this time.");
        } else {
            System.out.println("IT'S A TIE!");
        }
        System.out.println("------------------------\n");
    }
}
