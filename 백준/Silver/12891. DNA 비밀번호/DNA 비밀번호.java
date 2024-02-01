import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int S, P, ans;
	static char[] dna;
	static int minA, minC, minG, minT, cntC, cntG, cntT, cntA;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		dna = br.readLine().toCharArray();

		st = new StringTokenizer(br.readLine());
		minA = Integer.parseInt(st.nextToken());
		minC = Integer.parseInt(st.nextToken());
		minG = Integer.parseInt(st.nextToken());
		minT = Integer.parseInt(st.nextToken());

		solve();
		System.out.println(ans);
	}

	// 문자열을 쭉 처리하며 유효한지 검증
	static void solve() {
		// 맨 앞 P개 처리 <= P 개 중 ACGT 에 해당하는 문자이면 각각 해당하는 cntA, cntG... 증가
		for(int i=0; i<P; i++) {
			switch(dna[i]) {
				case 'A': cntA++; break;
				case 'C': cntC++; break;
				case 'G': cntG++; break;
				case 'T': cntT++; break;
			}
		}
        check();
		
		// P 부터 끝까지
		for(int i=P; i<S; i++) {	
			// 맨 앞 제거
			switch(dna[i-P]) {
				case 'A': cntA--; break;
				case 'C': cntC--; break;
				case 'G': cntG--; break;
				case 'T': cntT--; break;
			}
			// 맨 뒤 (새로운) 추가
			switch(dna[i]) {
				case 'A': cntA++; break;
				case 'C': cntC++; break;
				case 'G': cntG++; break;
				case 'T': cntT++; break;
			}
			check();
		}
	}
	
	// 현재 각 문자의 cnt 가 최소 조건을 만족하는지 확인 후 ans 증가
	static void check() {
		if(minA <= cntA && minC <= cntC && minG <= cntG && minT <= cntT) {
			ans++;
		}
	}
}
