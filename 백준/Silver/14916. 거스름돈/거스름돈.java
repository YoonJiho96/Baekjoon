import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int coin5 = n / 5;
        int remainder = n % 5;

        while (coin5 >= 0) {
            if (remainder % 2 == 0) {
                int coin2 = remainder / 2;
                System.out.println(coin5 + coin2);
                return;
            }
            coin5--;
            remainder += 5;
        }
        System.out.println(-1);
    }
}