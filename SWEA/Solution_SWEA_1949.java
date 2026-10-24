import java.util.*;
import java.io.*;

public class Solution_SWEA_1949 {

	static int N, K, answer;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			answer = 0;
			
			int maxHeight = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxHeight = Math.max(maxHeight, map[i][j]);
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == maxHeight) {
						visited = new boolean[N][N];
						
						visited[i][j] = true;
						dfs(i, j, 1, false);
					}
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}

	static void dfs(int r, int c, int length, boolean cut) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			if (visited[nr][nc]) continue;
			if (cut && map[r][c] <= map[nr][nc]) continue;
			
			if (map[r][c] <= map[nr][nc] && map[r][c] > map[nr][nc] - K) {
				int curHeight = map[nr][nc];
				map[nr][nc] = map[r][c] - 1;
				visited[nr][nc] = true;
				dfs(nr, nc, length + 1, true);
				map[nr][nc] = curHeight;
				visited[nr][nc] = false;
			} else if (map[r][c] > map[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc, length + 1, cut);
				visited[nr][nc] = false;
			}
		}
		
		answer = Math.max(answer, length);
	}
}
