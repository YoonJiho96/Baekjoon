import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int S; // 스위치 수
	static int[] switches;
	static int num; // 학생 수
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = Integer.parseInt(br.readLine());

		// 스위치 초기화
		switches = new int[S + 1];
		st = new StringTokenizer(br.readLine());
		for (int s = 1; s <= S; s++) {
			switches[s] = Integer.parseInt(st.nextToken());
		}

		// 학생 정보
		num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int check = Integer.parseInt(st.nextToken());

			// 남학생 동작. 받은 번호의 배수 상태 변경
			if (h == 1) {
				for (int j = check; j <= S; j += check) {
					switches[j] = (switches[j] == 0) ? 1 : 0;
				}
			}
			// 여학생 동작.
			else {
				// 현재 위치 변경(무조건)
				switches[check] = (switches[check] == 0) ? 1 : 0;

				// 좌우 넓혀가며 변경(범위 체크)
				int left = check;
				int right = check;
				while (true) {
					// 위치 조절
					left -= 1;
					right += 1;

					// 범위 체크
					if (left > 0 && right <= S) {
						if (switches[left] == switches[right]) {
							switches[left] = (switches[left] == 0) ? 1 : 0;
							switches[right] = switches[left];
						} else {
							break;
						}
					} else {
						break;
					}
				}
			}
		}
		for (int i = 1; i <= S; i++) {
			sb.append(switches[i]).append(" ");
			if(i%20==0) sb.append("\n");
		}
		System.out.println(sb);
	}
}