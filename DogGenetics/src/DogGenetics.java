import java.util.Random;
import java.util.Scanner;

class DogGenetics {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.print("What is your dog's name? ");
        String name = sc.nextLine();

        System.out.println("Well then, I have this highly reliable report on "+name+"'s prestigious background right here.\n");
        System.out.println(name +" is: \n");
        int rand1 = rand.nextInt(101);
        int rand2 = rand.nextInt(101-rand1);
        int rand3 = rand.nextInt(101-rand1-rand2);
        int rand4 = rand.nextInt(101-rand1-rand2-rand3);
        int rand5 = 100-rand1-rand2-rand3-rand4;

        System.out.println(rand1+"% St. Bernard\n" +
                rand2+"% Chihuahua\n" +
                rand3+"% Dramatic RedNosed Asian Pug\n" +
                rand4+"% Common Cur\n" +
                rand5+"% King Doberman\n");
        System.out.println("Wow, that's QUITE the dog!");
    }
}