import java.util.*;
import java.io.*;

public class Solution_SWEA_5250 {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	static class Node implements Comparable<Node> {
		int row, column, cost;
		
		public Node(int row, int column, int cost) {
			this.row = row;
			this.column = column;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
					
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(dijkstra(N, map)).append("\n");
		}
		
		System.out.println(sb);
	}

	static int dijkstra(int N, int[][] map) {
		boolean[][] visited = new boolean[N][N];
		int[][] cost = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.MAX_VALUE;
			}
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, map[0][0]));
		cost[0][0] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			visited[cur.row][cur.column] = true;
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.row + dr[d];
				int nc = cur.column + dc[d];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if (visited[nr][nc]) continue;
				
				int nCost = 1 + cost[cur.row][cur.column] 
						+ ((map[nr][nc] > map[cur.row][cur.column]) ? map[nr][nc] - map[cur.row][cur.column] : 0);
				if (cost[nr][nc] > nCost) {
					pq.offer(new Node(nr, nc, nCost));
					cost[nr][nc] = nCost;
				}
			}
		}
		
		return cost[N - 1][N - 1];
	}
}
