import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        System.out.println(getMod(A, B, C));
    }

    public static long getMod(long base, long exp, long mod) {
        if (exp == 0) {
            return 1;
        }

        long half = getMod(base, exp / 2, mod);
        half = (half * half) % mod;

        if (exp % 2 != 0) {
            half = (half * base) % mod;
        }
        return half;
    }
}