import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();

        long result = 0;
        long num = N - 2;
        N = num;
        for (int i = 1; i <= num; i++) {
            result += (N-- * i);
        }
        System.out.println(result);
        System.out.println(3);
    }
}