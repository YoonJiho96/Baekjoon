import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        // 사전 계산
        int[][] dp = new int[input.length][26];
        dp[0][input[0] - 'a'] = 1;
        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < 26; j++) {
                dp[i][j] = dp[i - 1][j];
            }
            dp[i][input[i] - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            sb.append(dp[r][a - 'a'] - dp[l][a - 'a'] + (input[l] == a ? 1 : 0)).append("\n");
        }

        System.out.println(sb);
    }
}