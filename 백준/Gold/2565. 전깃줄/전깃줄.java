import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int SIZE = 500;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] lines = new int[SIZE + 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            lines[A] = B;
        }

        int[] dp = new int[SIZE + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i <= SIZE; i++) {
            if (lines[i] == 0) continue;
            for (int j = 1; j < i; j++) {
                if (lines[j] == 0) continue;
                if (lines[i] > lines[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = Arrays.stream(dp).max().getAsInt();
        System.out.println(N - ans);
    }
}