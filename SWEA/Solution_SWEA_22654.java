import java.io.*;
import java.util.*;

public class Solution_SWEA_22654 {

	static int[] dr = {-1, 0, 1, 0}; // 위, 왼, 아래, 오 
	static int[] dc = {0, -1, 0, 1};
	static int N, startR, startC, endR, endC;
	static char[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			startR = -1; startC = -1; endR = -1; endC = -1;
			for (int i = 0; i < N; i++) {
				char[] chs = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					if (chs[j] == 'X') {
						startR = i;
						startC = j;
					} else if (chs[j] == 'Y') {
						endR = i;
						endC = j;
					}
					map[i][j] = (chs[j] == 'T') ? 'T' : 'G';
				}
			}
			int Q = Integer.parseInt(br.readLine());
			sb.append("#").append(test_case).append(" ");
			for (int i = 0; i < Q; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int C = Integer.parseInt(st.nextToken());
				char[] commands = st.nextToken().toCharArray();
				
				int r = startR, c = startC, d = 0;
				for (char ch : commands) {
					if (ch == 'A') {
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
						if (map[nr][nc] == 'T') continue;
						
						r += dr[d];
						c += dc[d];
					} else {
						if (ch == 'L') d = (d + 1) % 4;
						else {
							if (d - 1 == -1) d = 3;
							else d--;
						}
					}
				}
				
				sb.append((r == endR && c == endC) ? 1 : 0).append(" ");
			}
			
		}
		
		System.out.println(sb);
	}

}
