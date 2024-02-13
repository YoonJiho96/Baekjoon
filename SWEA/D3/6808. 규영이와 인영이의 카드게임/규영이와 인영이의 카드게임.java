import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[] input;
	static int[] src;
	static int[] tgt;
	static boolean[] select;
	static int win, lose;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input = new int[9]; // 규영 카드
			tgt = new int[9]; // 상대 카드 경우의 수
			src = new int[9]; // 상대 카드
			select = new boolean[9];

			// 규영 카드 초기화
			for (int i = 0; i < 9; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}

			// 상대 카드 초기화
			int[] temp = new int[19];
			for (int a : input) {
				temp[a] = 1;
			}
			int count = 0;
			for (int i = 1; i <= 18; i++) {
				if (temp[i] != 1) {
					src[count++] = i;
				}
			}

			win = 0;
			lose = 0;
			perm(0);
			sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb);
	}

	static void perm(int tgtIdx) {
		if (tgtIdx == 9) {
			checkWin();
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (select[i])
				continue;

			tgt[tgtIdx] = src[i];
			select[i] = true;
			perm(tgtIdx + 1);
			select[i] = false;
		}
	}
	static void checkWin() {
		int aSum = 0;
		int bSum = 0;

		for (int i = 0; i < 9; i++) {
			int a = input[i];
			int b = tgt[i];
			if (a > b)
				aSum += a + b;
			else
				bSum += a + b;
		}
		if (aSum > bSum)
			win += 1;
		else if (aSum < bSum)
			lose += 1;
	}
}