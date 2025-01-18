import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N = 123456;
    static boolean[] primes = new boolean[N * 2 + 1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        primes[0] = primes[1] = true;
        for (int i = 2; i * i <= N * 2; i++) {
            if (!primes[i]) {
                for (int j = i * i; j <= N * 2; j += i) {
                    primes[j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int sum = 0;
            for (int i = n + 1; i <= n * 2; i++) {
                if (!primes[i]) sum++;
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}