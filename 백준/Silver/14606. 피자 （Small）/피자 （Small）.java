import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[11];
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= 10; i++) {
            int left = i / 2;
            int right = (i / 2) + (i % 2);

            dp[i] = (left * right) + dp[left] + dp[right];
        }

        System.out.println(dp[N]);
    }
}