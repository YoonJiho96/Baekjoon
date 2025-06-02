import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        while (N-- > 0) {
            sum += Integer.parseInt(br.readLine());
        }
        System.out.println(sum);
    }
}