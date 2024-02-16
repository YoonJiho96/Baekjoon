import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            char[] input = br.readLine().toCharArray();
            int sum = 0;
            int cur = 1;
            for(char c : input) {
                if(c == 'O') {
                    sum = sum + cur++;
                }else {
                    cur = 1;
                }
            }
            System.out.println(sum);
        }
    }
}