import java.io.*;
import java.util.*;

public class Solution_SWEA_1226 {

	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static int startR, startC;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int tc = Integer.parseInt(br.readLine());
			map = new int[16][16];
			visited = new boolean[16][16];
			
			startR = -1; startC = -1;
			for (int i = 0; i < 16; i++) {
				char[] chs = br.readLine().toCharArray();
				for (int j = 0; j < 16; j++) {
					map[i][j] = chs[j] - '0';
					if (map[i][j] == 2) {
						startR = i;
						startC = j;
					} 
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(bfs(startR, startC) ? 1 : 0).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static boolean bfs(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] {r, c});
		visited[r][c] = true;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if (nr < 0 || nc < 0 || nr >= 16 || nc >= 16) continue;
				if (map[nr][nc] == 1) continue;
				if (map[nr][nc] == 3) return true;
				if (visited[nr][nc]) continue;
				
				queue.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
		}
		
		return false;
	}

}
