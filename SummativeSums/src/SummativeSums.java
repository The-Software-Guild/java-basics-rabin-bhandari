import java.sql.SQLOutput;

public class SummativeSums {
    public static void main(String[] args) {
        int[] first = new int[] { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
        int[] second = new int[]{ 999, -60, -77, 14, 160, 301 };
        int[] third = new int[]{ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130,
                140, 150, 160, 170, 180, 190, 200, -99 };

        System.out.println("#1 Array Sum: "+sumAll(first));
        System.out.println("#2 Array Sum: "+sumAll(second));
        System.out.println("#3 Array Sum: "+sumAll(third));

    }

    private static int sumAll(int[] arr) {
        int sum=0;
        for (int i: arr) {
            sum+=i;
        }
        return sum;
    }
}
