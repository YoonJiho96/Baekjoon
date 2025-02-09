import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final long MOD = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());

        long[] result = fastDoubling(n);

        System.out.println(result[0]);
    }

    static long[] fastDoubling(long n) {
        if (n == 0) {
            return new long[]{0, 1};
        }

        long[] half = fastDoubling(n / 2);
        long a = half[0];  // F(k)
        long b = half[1];  // F(k+1)

        long term = ((2 * b) % MOD - a + MOD) % MOD;
        long c = (a * term) % MOD;
        long d = ((a * a) % MOD + (b * b) % MOD) % MOD;

        if (n % 2 == 0) {
            return new long[]{c, d};
        } else {
            return new long[]{d, (c + d) % MOD};
        }
    }
}