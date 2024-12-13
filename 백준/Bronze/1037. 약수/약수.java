import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;
        int max = 0;

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int n : inputs) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        System.out.println(max * min);
    }
}