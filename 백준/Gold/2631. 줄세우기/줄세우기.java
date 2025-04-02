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

            // Collections.binarySearch(List<T> list, T key)
            // 1. key 가 list 안에 있으면 => key 인덱스 그대로 반환 
            // 2. key 가 list 안에 없으면 => [-(삽입 위치) - 1] 로 반환
            if (pos < 0) {
                pos = -pos - 1;
            }

            // LIS 길이 구하기
            if (pos == list.size()) {
                // 숫자가 LIS의 마지막 값 보다 큼 => LIS 길이 증가
                list.add(n);
            } else {
                // 중간 어딘가에 값이 들어갈 수 있음
                // => 자동으로 더 작은 값으로 교체됨
                list.set(pos, n);
            }
        }

        System.out.println(N - list.size());
    }
}