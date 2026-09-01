import java.io.*;
import java.util.*;

public class Solution2667 {

	static int N;
	static int[][] area;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		area = new int[N][N];
		visited = new boolean[N][N];
		int villageCount = 0;
		ArrayList<Integer> houseCount = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String[] strs = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				area[i][j] = Integer.parseInt(strs[j]);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (area[i][j] == 1 && visited[i][j] == false) {
					villageCount++;
					houseCount.add(bfs(i, j));
				}
			}
		}
		
		Collections.sort(houseCount);
		
		sb.append(villageCount).append("\n");
		for (int count : houseCount) {
			sb.append(count).append("\n");
		}
		
		System.out.println(sb);
	}

	public static int bfs(int startX, int startY) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] {startX, startY});
		visited[startX][startY] = true;
		int count = 1;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < N 
						&& visited[nx][ny] == false && area[nx][ny] == 1) {
					visited[nx][ny] = true;
					queue.offer(new int[] {nx, ny});
					count++;
				}
			}
		}
		
		return count;
	}
	
}
