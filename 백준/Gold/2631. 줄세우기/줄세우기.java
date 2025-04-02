import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // LIS : 이분탐색
        List<Integer> list = new ArrayList<>();
        for (int n : arr) {
            int pos = Collections.binarySearch(list, n);
            if (pos < 0) {
                pos = -pos - 1;
            }

            if (pos == list.size()) {
                list.add(n);
            } else {
                list.set(pos, n);
            }
        }

        System.out.println(N - list.size());
    }
}