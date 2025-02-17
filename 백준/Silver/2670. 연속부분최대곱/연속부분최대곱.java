import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        double dp = 0.0;
        double ans = 0.0;

        for (int i = 0; i < N; i++) {
            double num = Double.parseDouble(br.readLine());
            if (i == 0) {
                dp = num;
                ans = num;
            } else {
                dp = Math.max(num, dp * num);
                ans = Math.max(ans, dp);
            }
        }

        System.out.printf("%.3f", ans);
    }
}