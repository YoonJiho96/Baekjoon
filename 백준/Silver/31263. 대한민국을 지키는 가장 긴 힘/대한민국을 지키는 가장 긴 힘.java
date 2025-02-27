import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int MAX = 641;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String input = br.readLine();

        // dp[i] : 문자열을 i 까지 분할 했을 때 가능한 최소 공군 수
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (int len = 1; len <= 3; len++) {
                // 문자열 넘어가면 끝
                if (i + len > N) break;

                // 문자열 분할
                String part = input.substring(i, i + len);

                // 분한할 숫자의 가장 앞이 0이면 넘어감
                if (part.length() > 1 && part.charAt(0) == '0') continue;

                // 가능한 숫자인지 검사
                int num = Integer.parseInt(part);
                if (num >= 1 && num <= MAX) {
                    // 가능한 경우 => 숫자 하나 추가 해도 되는지 확인
                    dp[i + len] = Math.min(dp[i + len], dp[i] + 1);
                }
            }
        }
        System.out.println(dp[N]);
    }
}