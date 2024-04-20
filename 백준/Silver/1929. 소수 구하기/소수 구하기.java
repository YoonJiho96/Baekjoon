import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] prim = new int[M + 1];

		prim[1] = -1;
		for (int i = 2; i <= (int) Math.sqrt(M); i++) {
			if (prim[i] == 0) {
				for (int j = 2; i * j <= M; j++) {
					prim[i * j] = -1;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = N; i <= M; i++) {
			if (prim[i] == 0) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}
}