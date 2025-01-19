import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        getPrimes();

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(countGold(N)).append("\n");
        }
        System.out.println(sb);
    }

    static int N = 1000000;
    static boolean[] primes = new boolean[N + 1];

    static void getPrimes() {
        primes[0] = primes[1] = true;
        for (int i = 2; i * i <= N; i++) {
            if (!primes[i]) {
                for (int j = i * i; j <= N; j += i) {
                    primes[j] = true;
                }
            }
        }
    }

    static int countGold(int num) {
        int count = 0;

        for (int i = 2; i <= num / 2; i++) {
            if (!primes[i] && !primes[num - i]) {
                count++;
            }
        }
        return count;
    }
}