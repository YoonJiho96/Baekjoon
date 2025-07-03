import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int MAX = 0;
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            int sum;
            if (A == B && B == C) {
                sum = 10000 + A * 1000;
            } else {
                if (A == B) {
                    sum = 1000 + A * 100;
                } else if (B == C) {
                    sum = 1000 + B * 100;
                } else if (C == A) {
                    sum = 1000 + A * 100;
                } else {
                    sum = Math.max(A, Math.max(B, C)) * 100;
                }
            }
            MAX = Math.max(sum, MAX);
        }
        System.out.println(MAX);
    }
}