import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        int MAX = 0;

        // dp[i][j] : 문자열1 의 i 번째 문자와 문자여2의 j 번 째 문자가 같을 때, 가장 긴 공통 부분 문자열의 길이
        int[][] dp = new int[str1.length + 1][str2.length + 1];
        for (int i = 1; i <= str1.length; i++) {
            for (int j = 1; j <= str2.length; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    // 현재 것이 같으면, 이전 단어까지의 가장 긴 공통 부분 + 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    MAX = Math.max(dp[i][j], MAX);
                }
            }
        }

        System.out.println(MAX);
    }
}