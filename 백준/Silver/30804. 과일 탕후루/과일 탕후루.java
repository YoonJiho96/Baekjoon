import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // 오른쪽 포인터와 왼쪽 포인터
        int left = 0, right = 0;
        int max = 1; // 최대 길이 저장

        HashMap<Integer, Integer> map = new HashMap<>(); // 숫자 : 등장 횟수
        map.put(arr[left], 1); // 처음 값을 넣어줌

        while (right < N - 1) {
            right++; // 오른쪽 포인터를 먼저 증가

            // 유효 검사
            if (map.containsKey(arr[right])) {
                // 이미 map에 있는 값이면 등장 횟수 증가
                map.put(arr[right], map.get(arr[right]) + 1);
            } else {
                // 새로운 값이면 map에 추가
                map.put(arr[right], 1);
            }

            // 숫자가 2종류보다 많아지면 왼쪽 포인터를 이동
            while (map.size() > 2) {
                // 왼쪽 포인터의 값을 map에서 감소
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]); // 등장 횟수가 0이 되면 제거
                }
                left++; // 왼쪽 포인터 이동
            }

            // 현재 부분 배열의 길이 계산
            int len = right - left + 1;
            max = Math.max(max, len); // 최대 길이 갱신
        }

        System.out.println(max); // 최대 길이 출력
    }
}