import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static boolean[] checked;
	static int[] lst;
	static int[] result;
	static int N, M;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		checked = new boolean[N];

		lst = new int[N]; // 원본
		result = new int[M]; // 순열 결과
		for (int i = 0; i < N; i++) {
			lst[i] = i + 1;
		}

		perm(0);
	}

	static void perm(int tgtIdx) {
		if (tgtIdx == M) {
			System.out.println(Arrays.toString(result).replace("[", "").replace("]", "").replace(",", ""));
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
