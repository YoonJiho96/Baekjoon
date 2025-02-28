import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int max = Integer.MIN_VALUE;
            int curSum = 0;

            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                
                // 현재 수가 더 클 경우, 현재 수 부터 누적합을 시작하는 것이 더 이득
                curSum = Math.max(num, curSum + num);
                max = Math.max(max, curSum);
            }
            System.out.println(max);
        }
    }
}