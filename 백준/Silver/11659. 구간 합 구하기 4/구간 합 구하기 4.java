import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static StringTokenizer st;
	static int[] inputs;
	static int[] sums;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		// 값 입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 입력 배열 초기화
		inputs = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}
		
		// 구간 합 저장
		sums = new int[N+1];
		sums[1] = inputs[1];
		for(int i=2; i<=N; i++) {
			sums[i] = sums[i-1] + inputs[i];
		}

		// 케이스 별 값
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(sums[b] - sums[a-1]).append("\n");
		}
		System.out.println(sb);
	}
}