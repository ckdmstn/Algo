import java.io.*;
import java.util.*;

public class Solution_SWEA_7465 {

	static int[] node;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			node = new int[N + 1];
			for (int i = 1; i < node.length; i++) {
				node[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());
				
				int min = Math.min(p1, p2);
				int max = Math.max(p1, p2);
				
				union(min, max);
				
//				System.out.println(Arrays.toString(node));
			}
			
//			System.out.println("최종 : " + Arrays.toString(node));
			
			int answer = 0;
			for (int i = 1; i < node.length; i++) {
				if (i == node[i]) {
					answer++;
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int find(int current) {
		if (current == node[current]) {
			return current;
		}
		
		return node[current] = find(node[current]);
	}
	
	static void union(int p1, int p2) {
		int rootA = find(p1);
		int rootB = find(p2);
		if (rootA == rootB) return;
		node[rootB] = rootA;
	}

}
