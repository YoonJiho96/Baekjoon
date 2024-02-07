import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Main {
	static PriorityQueue<AbsNode> pqueue = new PriorityQueue<>((o1, o2) -> (o1.absNum == o2.absNum) ? o1.num - o2.num : o1.absNum - o2.absNum);
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int input = Integer.parseInt(st.nextToken());
			if(input == 0) {
				if(pqueue.isEmpty()) sb.append(0);
				else sb.append(pqueue.poll().num);
				sb.append("\n");
			}else {
				pqueue.add(new AbsNode(Math.abs(input), input));
			}
		}
		System.out.println(sb);
	}
}
class AbsNode {
	int absNum;
	int num;
	AbsNode(int a, int n) {
		absNum = a;
		num = n;
	}
}