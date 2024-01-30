import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[] checked;
	static int[] lst;
	static int[] result;
	static int N, M;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		checked = new boolean[N];

		lst = new int[N]; // 원본
		result = new int[M]; // 순열 결과
		for (int i = 0; i < N; i++) {
			lst[i] = i + 1;
		}

		perm(0);
		System.out.println(sb);
	}

	static void perm(int tgtIdx) {
		if (tgtIdx == M) {
			for(int n : result)
				sb.append(n).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = 0; i < lst.length; i++) {
			if(checked[i]) continue;
			result[tgtIdx] = lst[i];
			checked[i] = true;
			perm(tgtIdx + 1);
			checked[i] = false;
		}
	}
}