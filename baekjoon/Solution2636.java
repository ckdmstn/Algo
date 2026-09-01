import java.io.*;
import java.util.*;

public class Solution2636 {

	static int W;
	static int H;
	static int[][] area;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		area = new int[W][H];
		int cheeseCount = 0;
		
		for (int i = 0; i < area.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < area[i].length; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				cheeseCount += (area[i][j] == 1) ? 1 : 0;
			}
		}
		
		int answer = -1; 
		int hour = 0;
		while (cheeseCount > 0) {
			hour++;
			ArrayList<int[]> list = bfs(); // 녹는 치즈 area
			answer = list.size(); // 녹은 치즈 수
			cheeseCount -= answer; // 남는 치즈 수
			
			// 치즈 녹이기
			for (int[] a : list) {
				area[a[0]][a[1]] = 0;
			}
		}
		
		System.out.println(hour);
		System.out.println(answer);
	}
	
	static ArrayList<int[]> bfs() {
		ArrayList<int[]> list = new ArrayList<>();
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		boolean[][] visited = new boolean[W][H];
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] {0, 0});
		visited[0][0] = true;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				
				if (nx >= 0 && nx < W && ny >= 0 && ny < H
						&& visited[nx][ny] == false) {
					if (area[nx][ny] == 0) {
						queue.offer(new int[] {nx, ny});
					} else {
						list.add(new int[] {nx, ny});
					}
					
					visited[nx][ny] = true;
				}
			}
		}
		
		return list;
	}

}
