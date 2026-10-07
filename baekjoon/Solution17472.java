import java.util.*;
import java.io.*;

public class Solution17472 {

	static int N, M;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static int[] parents;
	
	static class Bridge implements Comparable<Bridge> {
		int start, end, length;

		public Bridge(int start, int end, int length) {
			this.start = start;
			this.end = end;
			this.length = length;
		}
		
		@Override
		public int compareTo(Bridge o) {
			return Integer.compare(this.length, o.length);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬 넘버링
		boolean[][] visited = new boolean[N][M];
		int landNum = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					landNumbering(visited, i, j, landNum++);
				}
			}
		}
		
		// 다리 후보 찾기
		ArrayList<Bridge> bridges = makeAllBridges();
		
		Collections.sort(bridges);
		
		parents = new int[landNum];
		for (int i = 1; i < parents.length; i++) {
			parents[i] = i;
		}
		
		// 가장 작은 다리부터 연결
		int answer = 0;
		int count = 0;
		for (Bridge bridge : bridges) {
			if (union(bridge.start, bridge.end)) {
				answer += bridge.length;
				count++;
			}
		}
		
		System.out.println((count == landNum - 2) ? answer : -1);
		
	}
	
	static void landNumbering(boolean[][] visited, int r, int c, int landNum) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] {r, c});
		visited[r][c] = true;
		map[r][c] = landNum;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if (visited[nr][nc]) continue;
				if (map[nr][nc] == 0) continue;
				
				queue.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
				map[nr][nc] = landNum;
			}
		}
	}
	
	static ArrayList<Bridge> makeAllBridges() {
		ArrayList<Bridge> bridges = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0) {
					for (int d = 0; d < 4; d++) {
						Bridge bridge = isValidBridge(i, j, d);
						
						if (bridge != null) bridges.add(bridge);
					}
				}
			}
		}
		
		return bridges;
	}
	
	static Bridge isValidBridge(int startR, int startC, int dir) {
		int count = 0;
		int landNum = map[startR][startC];
		while (true) {
			count++;
			
			startR += dr[dir];
			startC += dc[dir];
			
			if (startR < 0 || startC < 0 || startR >= N || startC >= M) return null;
			if (map[startR][startC] == landNum) return null;
			if (map[startR][startC] != landNum && map[startR][startC] != 0 && count - 1 >= 2) {
				return new Bridge(landNum, map[startR][startC], count - 1);
			} else if (map[startR][startC] != landNum && map[startR][startC] != 0) return null;
		}
	}
	
	static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		
		return true;
	}

}
