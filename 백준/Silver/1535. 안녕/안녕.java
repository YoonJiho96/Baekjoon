import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] health = new int[N];
        int[] joy = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            health[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            joy[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i] : 체력을 i만큼 소모했을 때 얻을 수 있는 최대 기쁨
        int[] dp = new int[101];

        for (int i = 0; i < N; i++) {
            // (j + health[i]) 가 100 미만
            for (int j = 100 - health[i] - 1; j >= 0; j--) {
                dp[j + health[i]] = Math.max(dp[j + health[i]], dp[j] + joy[i]);
            }
        }
        
        int answer = 0;
        for (int i = 0; i < 100; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}