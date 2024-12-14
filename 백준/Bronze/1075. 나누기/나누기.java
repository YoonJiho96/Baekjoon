import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int F = sc.nextInt();

        N = N - (N % 100);
        while (true) {
            if (N % F == 0) {
                System.out.printf("%02d%n", N % 100);
                break;
            }
            N += 1;
        }
    }
}