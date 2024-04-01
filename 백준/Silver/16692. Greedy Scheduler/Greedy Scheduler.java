import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 카운터
		int C = Integer.parseInt(st.nextToken()); // 손님

		st = new StringTokenizer(br.readLine());

		int[] nList = new int[N]; // 계산원
		int[] cList = new int[C]; // 손님
		for (int i = 0; i < C; i++) {
			cList[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		int idx = 0;
		while (idx < C) {
			// 계산원 채워넣기
			for (int i = 0; i < N; i++) {
				if (nList[i] == 0 && idx < C) {
					nList[i] = cList[idx++];
					sb.append(i + 1).append(" ");
				}
				nList[i]--;
			}
		}
		System.out.println(sb);
	}
}