import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> fact = new ArrayList<>();
        int f = 1;
        for (int i = 1; f <= N; i++) {
            fact.add(f);
            f *= i;
        }

        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int n : fact) {
            for (int i = n; i <= N; i++) {
                if (dp[i - n] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - n] + 1);
                }
            }
        }

        System.out.println(dp[N]);
    }
}