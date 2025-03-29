import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            arr[i] = s.charAt(i - 1) - '0';
        }

        // 불가능한 경우
        if (arr[1] == 0) {
            System.out.println(0);
            return;
        }

        // dp[i] : i 자리 숫자 까지 만들 수 있는 경우의 갯수
        long[] dp = new long[s.length() + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            if (arr[i] == 0) {
                if (arr[i - 1] == 1 || arr[i - 1] == 2) {
                    // 이전거랑 같이 쓰임
                    dp[i] = dp[i - 2];
                } else {
                    // 현재 것이 쓰일 방법이 없음
                    System.out.println(0);
                    return;
                }
            } else {
                // 현재 단독 사용
                dp[i] = dp[i - 1];
                int num = arr[i - 1] * 10 + arr[i];
                if (num >= 10 && num <= 26) {
                    // 앞에 것과 같이 쓰임
                    dp[i] = (dp[i] + dp[i - 2]) % MOD;
                }
            }
        }
        System.out.println(dp[s.length()]);
    }
}