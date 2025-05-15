import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = br.readLine().chars().map(c -> c - '0').toArray();
        int[] nums = new int[10];
        for (int n : input) {
            nums[n]++;
        }
        
        int max = 0;
        for (int i = 0; i < 10; i++) {
            if (i != 6 && i != 9) {
                max = Math.max(max, nums[i]);
            }
        }

        max = Math.max(max, (nums[6] + nums[9] + 1) / 2);
        System.out.println(max);
    }
}