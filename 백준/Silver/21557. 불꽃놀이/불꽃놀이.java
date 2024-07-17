import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  =Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = arr[0] - 1;
        int right = arr[N-1] - 1;

        int count = N - 2;

        for(int i=0; i<count - 1; i++) {
            if(left > right) {
                left -= 1;
            }else {
                right -= 1;
            }
        }

        System.out.println(Math.max(left, right));
    }
}
