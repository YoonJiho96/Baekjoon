import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] nums = br.readLine().chars().map(c -> c - '0').toArray();

        sb.append(Integer.toBinaryString(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            sb.append(String.format("%3s", Integer.toBinaryString(nums[i])).replace(' ', '0'));
        }
        System.out.println(sb);
    }
}