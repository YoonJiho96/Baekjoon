import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int pos = Arrays.binarySearch(list.toArray(), arr[i]);
            if (pos < 0) pos = -(pos + 1);

            if (pos == list.size()) {
                list.add(arr[i]);
            } else {
                list.set(pos, arr[i]);
            }
        }

        System.out.println(list.size());
    }
}