import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long N, M;
    static long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());

        arr = new long[(int)N];
        long high = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            if(arr[i] > high) high = arr[i];
        }

        long low = 0;
        long ans = 0;
        while(low <= high) {
            long mid = (low + high) / 2;
            long sum = 0;

            for(int i = 0; i < N; i++) {
                if(arr[i] > mid) sum += arr[i] - mid;
            }

            if(sum >= M) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(ans);
    }
}