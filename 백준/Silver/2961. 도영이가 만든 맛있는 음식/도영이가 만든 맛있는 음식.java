import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Node[] input;
	static boolean[] select;
	static List<Integer> result = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
	
		select = new boolean[N];
		input = new Node[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			input[i] = new Node(s, b);
		}
		
		subset(0);
		System.out.println(Collections.min(result));
	}
	
	static void subset(int srcIdx) {
		if (srcIdx == input.length) {
			int count = 0;
			int sSum = 1;
			int bSum = 0;
			
			for (int i=0; i<input.length; i++ ) {
				if(select[i]) {
					count++;
					sSum *= input[i].s;
					bSum += input[i].b;
				}
			}
			if (count == 0) return;
			result.add(Math.abs(sSum- bSum));
			return;
		}
		
		select[srcIdx] = true;
		subset(srcIdx + 1);
		select[srcIdx] = false;
		subset(srcIdx + 1);
	}
}

class Node {
	int s;
	int b;

	Node(int s, int b) {
		this.s = s;
		this.b = b;
	}
}
