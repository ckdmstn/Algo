import java.util.*;
import java.io.*;

public class Solution_SWEA_1238 {

	static ArrayList<Integer>[] list;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			list = new ArrayList[101];
			visited = new boolean[101];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				if (list[from] == null) {
					list[from] = new ArrayList<Integer>();
				}
				list[from].add(to);
			}
			
			sb.append("#").append(test_case).append(" ").append(bfs(start)).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static int bfs(int start) {
		int maxWeight = -1;
		int maxNum = -1;
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {start, 0});
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			if (maxWeight < cur[1]) {
				maxWeight = cur[1];
				maxNum = cur[0];
			} else if (maxWeight == cur[1]) {
				maxNum = Math.max(maxNum, cur[0]);
			}
			
			if (list[cur[0]] == null) continue;
			
			for (Integer next : list[cur[0]]) {
				if (visited[next]) continue;
				
				queue.offer(new int[] {next, cur[1] + 1});
				visited[next] = true;
			}
		}
		
		return maxNum;
	}
}
