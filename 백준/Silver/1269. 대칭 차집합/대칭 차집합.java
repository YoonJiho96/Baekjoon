import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        HashSet<Integer> aArr = new HashSet<>(getArr(a));
        HashSet<Integer> bArr = new HashSet<>(getArr(b));

        System.out.println(getResult(aArr, bArr) + getResult(bArr, aArr));
    }

    static List<Integer> getArr(int n) throws Exception {
        List<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        return arr;
    }

    static int getResult(HashSet<Integer> arr1, HashSet<Integer> arr2) {
        int sum = 0;
        for (int n : arr1) {
            if (!arr2.contains(n)) {
                sum++;
            }
        }
        return sum;
    }
}