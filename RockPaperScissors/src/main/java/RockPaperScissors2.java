import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors2 {
    private static String[] options = {"Rock", "Paper", "Scissors"};
    private static int[] overAllResults = {0,0,0}; // wins, losses and ties

    public static void main(String[] args) {
        boolean playAgain = false;
        Scanner sc = new Scanner(System.in);
        do {
            playGame();
            String input = "";
            while (!(input.equals("yes") || input.equals("no"))) {
                System.out.println("Would you like to play again? (Yes/No)");
                try {
                    input = sc.nextLine().toLowerCase();
                    if (input.equals("yes")) {
                        playAgain=true;
                    } else if (input.equals("no")) {
                        playAgain=false;
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    System.out.println("Invalid Entry.");
                    sc.nextLine();
                }
            }
        } while (playAgain);
    }

    private static void playGame(){
        Random rand = new Random();
        int rounds = getRounds();
        for (int i=0;i<rounds;i++) {
            int userChoice = getUserChoice();
            int computerChoice = rand.nextInt(3);
            System.out.println("You chose: " + options[userChoice]);
            System.out.println("The Computer chose: "+options[computerChoice]);
            computeRoundResult(userChoice,computerChoice);
        }
        System.out.println("You had "+overAllResults[0]+" wins, "+overAllResults[1]+" losses and tied "+overAllResults[2]+" time(s) against the computer.");
        resetScores();
    }
    private static int getUserChoice() {
        Scanner sc = new Scanner(System.in);
        int userChoice = 0;
        while (userChoice<1||userChoice>3) {
            System.out.println("For this round, what would you like to choose:\n\n" +
                    "  1: Rock\n" +
                    "  2: Paper\n" +
                    "  3: Scissors\n");
            try {
                userChoice = sc.nextInt();
                if (userChoice<1 || userChoice>3) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter 1,2 or 3.");
                sc.nextLine();
            }
        }
        return userChoice-1;
    }
    private static int getRounds() {
        Scanner sc = new Scanner(System.in);
        int rounds = 0;
        while (rounds<1||rounds>10) {
            System.out.println("How many rounds do you want to play?");
            try {
                rounds = sc.nextInt();
                if (rounds<1 || rounds>10) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Not within the range of 1-10. Please try again.");
                sc.nextLine();
            }
        }
        return rounds;
    }
    private static void computeRoundResult(int user, int computer){
        if (user == computer) {
            System.out.println("It's a Tie!");
            overAllResults[2]++;
        } else if (user == (computer+1)%3) {
            System.out.println("You Win!");
            overAllResults[0]++;
        } else {
            System.out.println("You lose, better luck next time.");
            overAllResults[1]++;
        }
    }
    private static void resetScores(){
        System.out.println("\n------------------------");
        if (overAllResults[0] == overAllResults[1]) {
            System.out.println("IT'S A TIE!");
        } else {
            if (overAllResults[0]>overAllResults[1]) {
                System.out.println("Congratulations! YOU WON!");
            } else{
                System.out.println("Unlucky! The Computer won this time.");
            }
        }
        System.out.println("------------------------\n");
        Arrays.fill(overAllResults, 0);
    }
}
