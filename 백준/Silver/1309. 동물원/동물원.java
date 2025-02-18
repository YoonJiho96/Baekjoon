import java.util.Scanner;

public class Main {
    static final int MOD = 9901;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int none = 1;
        int left = 1;
        int right = 1;

        for (int i = 2; i <= N; i++) {
            int curNone = (none + left + right) % MOD;
            int curLeft = (none + right) % MOD;
            int curRight = (none + left) % MOD;

            none = curNone;
            left = curLeft;
            right = curRight;
        }

        System.out.println((none + left + right) % MOD);
    }
}