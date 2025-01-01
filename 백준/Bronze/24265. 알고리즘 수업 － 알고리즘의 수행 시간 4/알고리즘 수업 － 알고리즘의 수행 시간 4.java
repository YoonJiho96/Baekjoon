import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextInt();
        if (N % 2 == 0) {
            N = (N * (N / 2 - 1)) + (N / 2);
        } else {
            N = (N * (N / 2));
        }
        System.out.println(N);
        System.out.println(2);
    }
}