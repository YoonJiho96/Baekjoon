import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int result = N;
        int count = 0;
        do {
            result = (result % 10) * 10 + (((result / 10) + (result % 10)) % 10);
            count++;
        } while (result != N);
        System.out.println(count);
    }
}