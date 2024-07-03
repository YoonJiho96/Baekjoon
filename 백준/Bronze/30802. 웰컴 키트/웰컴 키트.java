import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long N = Long.parseLong(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] inputs = new long[6];
        for(int i = 0; i < 6; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        long ans1 = 0;
        for(int i = 0; i < 6; i++) {
            if(inputs[i] % T == 0) {
                ans1 += (inputs[i] / T);
            }else {
                ans1 += (inputs[i] / T) + 1;
            }
        }
        sb.append(ans1).append("\n");
        sb.append(N / P).append(" ");
        sb.append(N % P).append("\n");

        System.out.println(sb);
    }
}
