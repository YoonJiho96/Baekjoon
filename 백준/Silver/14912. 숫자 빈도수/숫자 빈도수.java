import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] freq = new int[10];
        for (int i = 1; i <= n; i++) {
            char[] nums = String.valueOf(i).toCharArray();

            for (char c : nums) {
                freq[c - '0']++;
            }
        }

        System.out.println(freq[d]);
    }
}