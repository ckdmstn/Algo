import java.io.*;
import java.util.*;

public class Solution4485 {

	static int[][] cave;
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; N != 0; test_case++) {
			cave = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = dijkstra(N);
			
			sb.append("Problem ").append(test_case).append(": ").append(answer).append("\n");
			
			N = Integer.parseInt(br.readLine());
		}
		
		System.out.println(sb);
	}
	
	static int dijkstra(int N) {
		int[][] minCost = new int[N][N];
		
		for (int[] row : minCost) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		
		minCost[0][0] = cave[0][0];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, minCost[0][0]));
		
		while (!pq.isEmpty()) {
			Node current = pq.poll();
			
			if (current.cost > minCost[current.r][current.c]) continue;
			
			for (int d = 0; d < 4; d++) {
				int nr = current.r + dr[d];
				int nc = current.c + dc[d];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				
				int newCost = cave[nr][nc] + current.cost;
				if (newCost < minCost[nr][nc]) {
					minCost[nr][nc] = newCost;
					pq.offer(new Node(nr, nc, newCost));
				}
			}
		}
		
		return minCost[N - 1][N - 1];
	}
	
	static class Node implements Comparable<Node> {
		int r;
		int c;
		int cost;
		
		public Node(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

}
