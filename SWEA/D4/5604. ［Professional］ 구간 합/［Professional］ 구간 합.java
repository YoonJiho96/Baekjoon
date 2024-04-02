import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static long A, B, ans;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());

			ans = 0;
			long pos = 1; // 자리수

			while (A <= B) { // 최초 시작, 중간 10으로 나눈 뒤
				// X9 ~ Y0 포맷이 아닌 경우 찌꺼기 처리

				// from 찌꺼기
				// 맨 뒷자리가 0이 될 때까지
				while (A % 10 != 0 && A <= B) {
					// A 수 처리
					calc(A, pos);
					A++;
				}
				if (A > B || A == 0 && B == 0)
					break;

				// to 찌꺼기
				// 맨 뒷자리가 9가 될 때까지 감소해 간다.
				while (B % 10 != 9 && A <= B) {
					// B 수 처리
					calc(B, pos);
					B--;
				}

				// 두 수를 10으로 나누고 필요한 계산
				A /= 10;
				B /= 10;

				long m = (B - A + 1) * pos;// pos 는 나눈 횟수 최초 1
				ans += 45 * m;

				pos *= 10;
			}

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static void calc(long n, long t) {
		while (n > 0) {
			ans += (n % 10) * t;
			n /= 10;
		}
	}
}