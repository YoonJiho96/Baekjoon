import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int MAX = 0;
        int before = arr[0];
        int ascCount = 0;
        int descCount = 0;

        for (int num : arr) {
            if (num >= before) {
                MAX = Math.max(++ascCount, MAX);
            } else {
                ascCount = 1;
            }

            if (num <= before) {
                MAX = Math.max(++descCount, MAX);
            } else {
                descCount = 1;
            }

            before = num;
        }

        System.out.println(MAX);
    }
}