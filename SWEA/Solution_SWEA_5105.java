import java.util.*;
import java.io.*;

public class Solution_SWEA_5105 {

	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static int N, endR, endC;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			
			int startR = -1, startC = -1; endR = -1; endC = -1;
			for (int i = 0; i < N; i++) {
				char[] chs = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = chs[j] - '0';
					if (map[i][j] == 2) {
						startR = i; startC = j;
					} else if (map[i][j] == 3) {
						endR = i; endC = j;
					}
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(bfs(startR, startC)).append("\n");
		}
		
		System.out.println(sb);
	}

	static int bfs(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r, c, 0});
		visited[r][c] = true;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if (visited[nr][nc]) continue;
				if (map[nr][nc] == 1) continue;
				
				if (map[nr][nc] == 3) return cur[2];
				
				queue.offer(new int[] {nr, nc, cur[2] + 1});
				visited[nr][nc] = true;
			}
		}
		
		return 0;
	}
}
