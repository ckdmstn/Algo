import java.io.*;
import java.util.*;

public class Solution_SWEA_1767 {

	static int N, maxCount, answer, totalLineCount;
	static int[][] map;
	static boolean[][] connected;
	static ArrayList<int[]> coreList;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			connected = new boolean[N][N];
			coreList = new ArrayList<>();
			maxCount = totalLineCount = 0;
			answer = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if (i == 0 || j == 0 || i == N - 1 || j == N - 1) {
							connected[i][j] = true;
						} else {
							coreList.add(new int[] {i, j});
						}
					}
				}
			}
			
			connect(0, 0);
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void connect(int idx, int curCount) {
		if (idx == coreList.size()) {
			if (curCount > maxCount) {
				maxCount = curCount;
				answer = totalLineCount;
			} else if (curCount == maxCount) {
				answer = Math.min(answer, totalLineCount);
			}
			return;
		}
		
		if (curCount + (coreList.size() - idx) < maxCount) {
			return;
		}
		
		int[] cur = coreList.get(idx);
		int r = cur[0], c = cur[1];
		
		for (int i = 0; i < 5; i++) {
			// dir : 0 - 오, 1 - 왼, 2 - 위, 3 - 아래
			if (i != 4) {
				int len = isConnectByDir(r, c, i);
				if (len != -1) {
					changeConnect(r, c, i, true);
					connected[r][c] = true;
					totalLineCount += len;
					
					connect(idx + 1, curCount + 1);
					
					totalLineCount -= len;
					changeConnect(r, c, i, false);
					connected[r][c] = false;
				}
			} else {
				connect(idx + 1, curCount);
			}
		}
	}
	
	static int isConnectByDir(int r, int c, int dir) {
		// dir : 0 - 오, 1 - 왼, 2 - 위, 3 - 아래
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		int length = 0;
		
		while (true) {
			if (nr >= N || nr < 0 || nc >= N || nc < 0) {
				return length;
			}
			
			if (connected[nr][nc] || map[nr][nc] == 1) {
				return -1;
			}
			
			length++;
			nr += dr[dir];
			nc += dc[dir];
		}
	}
	
	static void changeConnect(int r, int c, int dir, boolean con) {
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		
		while (nr < N && nr >= 0 && nc < N && nc >= 0) {
			connected[nr][nc] = con;
			
			nr += dr[dir];
			nc += dc[dir];
		}
	}

}
