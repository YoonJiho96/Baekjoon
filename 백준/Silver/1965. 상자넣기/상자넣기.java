import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int N : arr) {
            int pos = Collections.binarySearch(list, N);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            if (pos == list.size()) {
                list.add(N);
            } else {
                list.set(pos, N);
            }
        }
        System.out.println(list.size());
    }
}