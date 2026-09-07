import java.io.*;
import java.util.*;

public class Solution4179 {

	static int R, C;
	static int[][] maze;
	static int answer;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static ArrayList<int[]> fireCoors;
	static int[][] fireTime;
	static boolean[][] fireVisited;
	static int[][] movements;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		maze = new int[R][C];
		answer = Integer.MAX_VALUE;
		fireTime = new int[R][C];
		fireVisited = new boolean[R][C];
		movements = new int[R][C];
		visited = new boolean[R][C];
		
		fireCoors = new ArrayList<>();
		int[] currentCoor = {-1, -1};
		for (int i = 0; i < R; i++) {
			char[] chs = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				// 지나갈 수 있는 공간 : 0 / 벽 : 1 / 불 : 2 / 초기 위치 : 3 
				if (chs[j] == '.') maze[i][j] = 0;
				else if (chs[j] == '#') maze[i][j] = 1;
				else if (chs[j] == 'F') { 
					maze[i][j] = 2;
					fireCoors.add(new int[] {i, j});
				}
				else if (chs[j] == 'J') {
					maze[i][j] = 3;
					currentCoor[0] = i;
					currentCoor[1] = j;
				}
			}
		}
		
		// 불 time 계산
		fireTimeBfs();
		
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(fireTime[i][j] + " ");
//			} System.out.println();
//		} System.out.println();
		
		// 탈출 시도 
		bfs(currentCoor);
		
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(movements[i][j] + " ");
//			} System.out.println();
//		} System.out.println();
		
		System.out.println((answer == Integer.MAX_VALUE) ? "IMPOSSIBLE" : answer);
		
	}
	
	static void fireTimeBfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		for (int[] a : fireCoors) {
			queue.offer(a);
			fireVisited[a[0]][a[1]] = true;
			fireTime[a[0]][a[1]] = 0;
		}
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = current[0] + dr[d];
				int nc = current[1] + dc[d];
				
				if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				if (maze[nr][nc] == 1) continue;
				if (fireVisited[nr][nc]) continue;
				
				queue.offer(new int[] {nr, nc});
				fireVisited[nr][nc] = true;
				fireTime[nr][nc] = fireTime[current[0]][current[1]] + 1;
			}
		}
	}

	static void bfs(int[] start) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(start);
		visited[start[0]][start[1]] = true;
		movements[start[0]][start[1]] = 0;
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = current[0] + dr[d];
				int nc = current[1] + dc[d];
				
				int nextMovements = movements[current[0]][current[1]] + 1;
				if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
					answer = Math.min(answer, nextMovements);
					continue;
				}
				if (maze[nr][nc] == 1) continue;
				if (visited[nr][nc]) continue;
				if (fireTime[nr][nc] <= nextMovements) continue;
				
				queue.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
				movements[nr][nc] = nextMovements;
			}
		}
	}
}
