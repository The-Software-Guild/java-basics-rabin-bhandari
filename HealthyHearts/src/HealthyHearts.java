import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age;
        System.out.print("What is your age? ");
        try {
            age = sc.nextInt();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int heartRate = 220-age;
        System.out.println("Your maximum heart rate should be "+heartRate+" beats per minute");
        System.out.println("Your target HR Zone is "+ heartRate/2 + " - "+Math.ceil(heartRate*85/100) + " beats per minute");
    }
}
