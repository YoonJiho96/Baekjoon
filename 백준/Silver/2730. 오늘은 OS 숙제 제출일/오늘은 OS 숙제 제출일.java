import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] month = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365 };
	static int[] monthY = { 0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335, 366 };

	static int T;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			// 데이터 입력
			String[] input = br.readLine().split(" ");
			String[] limit = input[0].split("/");
			String[] submit = input[1].split("/");

			int m1 = Integer.parseInt(limit[0]);
			int d1 = Integer.parseInt(limit[1]);
			int y1 = Integer.parseInt(limit[2]);

			int m2 = Integer.parseInt(submit[0]);
			int d2 = Integer.parseInt(submit[1]);

			int lastYearDate = isLeapYear(y1 - 1) ? 366 : 365;
			int thisYearDate = isLeapYear(y1) ? 366 : 365;

			// 작년 기준. 해당 날짜까지 일 수 계산.
			int deadlineDate = lastYearDate + (isLeapYear(y1) ? (monthY[m1 - 1] + d1) : (month[m1 - 1] + d1));
			int submitLastYearDate = isLeapYear(y1 - 1) ? (monthY[m2 - 1] + d2) : month[m2 - 1] + d2;
			int submitThisYearDate = lastYearDate + (isLeapYear(y1) ? (monthY[m2 - 1] + d2) : (month[m2 - 1] + d2));
			int submitNextYearDate = lastYearDate + thisYearDate
					+ (isLeapYear(y1 - 1) ? (monthY[m2 - 1] + d2) : (month[m2 - 1] + d2));

			// 제출일과 차이
			int gapLast = deadlineDate - submitLastYearDate;	// 작년에 제출한 경우
			int gapThis = deadlineDate - submitThisYearDate;	// 올해에 제출한 경우
			int gapNext = deadlineDate - submitNextYearDate;	// 다음해에 제출한 경우

			// 최소값 계산
			int min = min(gapLast, gapThis, gapNext);
			if (min == 0) {
				sb.append("SAME DAY").append("\n");
				continue;
			} else if (min <= 7) {
				int year = 0;
				int gap = 0;
				if (min == Math.abs(gapLast)) {
					year = y1 - 1;
					gap = gapLast;
				} else if (min == Math.abs(gapThis)) {
					year = y1;
					gap = gapThis;
				} else if (min == Math.abs(gapNext)) {
					year = y1 + 1;
					gap = gapNext;
				}
				sb.append(input[1] + "/" + year + " IS " + min);
				if (Math.abs(gap) == 1) {
					sb.append(" DAY ");
				} else {
					sb.append(" DAYS ");
				}

				if (gap < 0) {
					sb.append("AFTER");
				} else {
					sb.append("PRIOR");
				}
			} else {
				sb.append("OUT OF RANGE");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static int getYear(int y1, int min, int gap) {
		int year = 0;
		if (min == Math.abs(gap)) {
			year = y1 - 1;
		} else if (min == Math.abs(gap)) {
			year = y1;
		} else if (min == Math.abs(gap)) {
			year = y1 + 1;
		}
		return year;
	}

	public static int min(int a, int b, int c) {
		int A = Math.abs(a);
		int B = Math.abs(b);
		int C = Math.abs(c);
		int min = A;

		if (min > B)
			min = B;
		if (min > C)
			min = C;
		return min;
	}

	public static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
}