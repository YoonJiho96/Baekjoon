import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        if (Arrays.stream(arr).sum() <= M) {
            System.out.println(arr[N - 1]);
            return;
        }

        int low = 0;
        int high = arr[N - 1];
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            long sum = 0;

            for (int n : arr) {
                if (n > mid) {
                    sum += mid;
                } else {
                    sum += n;
                }
            }

            if (sum <= M) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(result);
    }
}