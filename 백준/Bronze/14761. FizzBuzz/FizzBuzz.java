import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (i % X == 0) {
                sb.append("Fizz");
            }
            if (i % Y == 0) {
                sb.append("Buzz");
            }
            if (i % X != 0 && i % Y != 0) {
                sb.append(i);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}