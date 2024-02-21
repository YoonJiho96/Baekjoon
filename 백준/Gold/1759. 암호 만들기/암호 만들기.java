import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static char[] input, tgt;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		input = new char[C];
		tgt = new char[L];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			input[i] = st.nextToken().toCharArray()[0];

		}
		Arrays.sort(input);
		comb(0, 0);
		System.out.println(sb);
	}

	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == L) {
			if (check()) {
				sb.append(new String(tgt)).append("\n");
			}
			return;
		}

		for (int i = srcIdx; i < C; i++) {
			tgt[tgtIdx] = input[i];
			comb(i + 1, tgtIdx + 1);
		}
	}

	static boolean check() {
		int cnt = 0;
		for (char c : tgt) {
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				cnt++;
				if (L - cnt < 2) {
					return false;
				}
			}
		}
		if(cnt == 0) return false;
		return true;
	}
}