import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

        int[] neg = new int[N];
        for (int i = 0; i < N; i++) {
            neg[i] = -arr[i];
        }

        ArrayList<Integer> lis = new ArrayList<>();
        for (int x : neg) {
            if (lis.isEmpty() || x > lis.get(lis.size() - 1)) {
                lis.add(x);
            } else {
                int idx = lowerBound(lis, x);
                lis.set(idx, x);
            }
        }

        int ldsLength = lis.size();
        System.out.println(N - ldsLength);
    }

    public static int lowerBound(ArrayList<Integer> lis, int target) {
        int lo = 0, hi = lis.size() - 1;
        int ans = hi + 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (lis.get(mid) >= target) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}