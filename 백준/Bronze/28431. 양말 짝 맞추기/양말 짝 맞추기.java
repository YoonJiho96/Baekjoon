import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num]++;
        }

        for (int i = 0; i < 10; i++) {
            if(arr[i] % 2 != 0) {
                System.out.println(i);
            }
        }
    }
}