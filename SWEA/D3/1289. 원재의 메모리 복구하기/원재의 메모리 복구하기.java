import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	static int T, count; // local 변수 사용이 더 빠르긴 함. 가독성 때문에 사용.
	static char[] input;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());

		for (int t = 1; t <= T; t++) {
			// 테케 별 풀이.
			input = bf.readLine().toCharArray();
			int cnt = input.length;

			// 최적화
			count = 0;
			char current = '0';
			
			for (int i = 0; i < cnt; i++) {
				if(input[i] != current) {
					count++;
				}
				current = input[i];
			}
			System.out.println("#" + t + " " + count);
		}
	}
}