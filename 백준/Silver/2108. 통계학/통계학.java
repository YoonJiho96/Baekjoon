import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int N;
	static int[] numbers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		List<Integer> list = new ArrayList<>();
		numbers = new int[8001];
		int mostValue = 0;

		double total = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			total += (float) num;

			list.add(num);

			numbers[num + 4000]++; // num 값 등장 수
			if (numbers[num + 4000] > mostValue) {
				mostValue = numbers[num + 4000];
			}
		}
		list.sort((o1, o2) -> o1 - o2);

		// 산술 평균
		System.out.println(Math.round(total / N));

		// 중앙 값
		System.out.println(list.get(N / 2));

		// 최빈값
		int temp = 0;
		int most = 0;
		for (int i = 0; i <= 8000; i++) {
			if (numbers[i] == mostValue) {
				temp++;
				most = i - 4000;
				if (temp == 2) {
					break;
				}
			}
		}
		System.out.println(most);

		// 범위 값
		System.out.println(list.get(N - 1) - list.get(0));
	}
}