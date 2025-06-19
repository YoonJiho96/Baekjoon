import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum1 = 0;
        int sum2 = 0;

        boolean flag = false;
        for (int i = 0; i < arr1.length; i++) {
            sum1 += arr1[i];
            if (sum1 > sum2) {
                flag = true;
                break;
            }
            sum2 += arr2[i];
        }

        System.out.println(flag ? "Yes" : "No");
    }
}