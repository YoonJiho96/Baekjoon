import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] A = input[0].chars().map(c -> c - '0').toArray();
        int[] B = input[1].chars().map(c -> c - '0').toArray();

        long result = 0;
        for (int a : A) {
            for (int b : B) {
                result += (long) a * b;
            }
        }
        System.out.println(result);
    }
}