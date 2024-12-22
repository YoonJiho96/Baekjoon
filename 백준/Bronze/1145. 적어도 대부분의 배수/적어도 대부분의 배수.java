import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int c = 1;
        while (true) {
            int count = 0;
            for (int n : nums) {
                if (c % n == 0) {
                    count++;
                }
            }
            if (count >= 3) {
                System.out.println(c);
                break;
            }
            c++;
        }
    }
}