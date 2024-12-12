import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[] temp = br.readLine().toCharArray();
        for (int n = 0; n < N - 1; n++) {
            char[] input = br.readLine().toCharArray();
            for (int i = 0; i < input.length; i++) {
                if (input[i] != temp[i]) {
                    temp[i] = '?';
                }
            }
        }
        System.out.println(new String(temp));
    }
}