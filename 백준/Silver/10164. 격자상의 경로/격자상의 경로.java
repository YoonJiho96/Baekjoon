import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static BigInteger combination(int n, int k) {
        BigInteger result = BigInteger.ONE;
        if (k > n - k) {
            k = n - k;
        }
        for (int i = 1; i <= k; i++) {
            result = result.multiply(BigInteger.valueOf(n - i + 1));
            result = result.divide(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        if (K == 0) {
            BigInteger paths = combination((N - 1) + (M - 1), N - 1);
            System.out.println(paths);
        } else {
            int r = (K - 1) / M + 1;
            int c = (K - 1) % M + 1;

            BigInteger firstPart = combination(r + c - 2, r - 1);
            BigInteger secondPart = combination((N - r) + (M - c), N - r);
            System.out.println(firstPart.multiply(secondPart));
        }
    }
}