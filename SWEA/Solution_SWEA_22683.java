import java.util.*;
import java.io.*;

public class Solution_SWEA_22683 {

	static int N, K, startR, startC, endR, endC;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static boolean[][][][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
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
					map[i][j] = (chs[j] == 'T') ? 1 : 0;
				}
			}
			visited = new boolean[N][N][4][K + 1]; // row, column, 방향, 벤 횟수
			
			sb.append("#").append(test_case).append(" ").append(bfs()).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int bfs() {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] {startR, startC, 0, 0, 0}); // r, c, 방향, 벤 횟수, 조작 횟수
		visited[startR][startC][0][0] = true; // row, column, 방향, 벤 횟수
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			// 오른쪽 회전
			int nd = (cur[2] - 1 == -1) ? 3 : cur[2] - 1;
			if (!visited[cur[0]][cur[1]][nd][cur[3]]) {
				queue.offer(new int[] {cur[0], cur[1], nd, cur[3], cur[4] + 1});
				visited[cur[0]][cur[1]][nd][cur[3]] = true;
			}
			
			// 왼쪽 회전
			nd = (cur[2] + 1) % 4;
			if (!visited[cur[0]][cur[1]][nd][cur[3]]) {
				queue.offer(new int[] {cur[0], cur[1], nd, cur[3], cur[4] + 1});
				visited[cur[0]][cur[1]][nd][cur[3]] = true;
			}
			
			// 전진
			int nr = cur[0] + dr[cur[2]];
			int nc = cur[1] + dc[cur[2]];
			
			if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			if (cur[3] >= K && map[nr][nc] == 1) continue;
			int cutCount = cur[3];
			if (map[nr][nc] == 1) {
				if (visited[nr][nc][cur[2]][cur[3] + 1]) continue;
				else cutCount++;
			}
			if (map[nr][nc] == 0 && visited[nr][nc][cur[2]][cur[3]]) continue;
			
			if (nr == endR && nc == endC) return cur[4] + 1;
			
			queue.offer(new int[] {nr, nc, cur[2], cutCount, cur[4] + 1});
			visited[nr][nc][cur[2]][cutCount] = true;
		}
		
		return -1;
	}

}
