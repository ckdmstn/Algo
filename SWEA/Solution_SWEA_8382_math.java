import java.io.*;
import java.util.*;

public class Solution_SWEA_8382_math {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int xAbs = Math.abs(x1 - x2);
			int yAbs = Math.abs(y1 - y2);
			int minus = Math.abs(xAbs - yAbs);
			int answer;
			if (minus == 0 || minus == 1) {
				answer = xAbs + yAbs;
			} else if (minus % 2 == 0) {
				answer = Math.max(xAbs, yAbs) * 2;
			} else {
				answer = Math.max(xAbs, yAbs) * 2 - 1;
			}
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb);
	}

}
