import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static long N, D, K;
	static List<Worker> wList = new ArrayList<>();

	// K 명 이하 해고
	// 최소 D 달러 절약
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		D = Long.parseLong(st.nextToken());
		K = Long.parseLong(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			long pay = Long.parseLong(st.nextToken());
			wList.add(new Worker(name, pay));
		}
		Collections.sort(wList, (o1, o2) -> Long.compare(o2.pay, o1.pay));

		StringBuilder sb = new StringBuilder();
		long total = 0;
		for (int i = 0; i < K; i++) {
			Worker w = wList.get(i);
			total += w.pay;
			sb.append(w.name).append(", YOU ARE FIRED!\n");
			if (total >= D) {
				System.out.println(i + 1);
				System.out.println(sb);
				return;
			}
		}
		System.out.println("impossible");
	}

	static class Worker {
		String name;
		long pay;

		Worker(String name, long pay) {
			this.name = name;
			this.pay = pay;
		}
	}
}