import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        long sum = 0L;
        long xorSum = 0L;

        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                long n = Long.parseLong(st.nextToken());
                sum += n;
                xorSum ^= n;
            } else if (cmd == 2) {
                long n = Long.parseLong(st.nextToken());
                sum -= n;
                xorSum ^= n;
            } else if (cmd == 3) {
                sb.append(sum).append("\n");
            } else if (cmd == 4) {
                sb.append(xorSum).append("\n");
            }
        }
        System.out.println(sb);
    }
}