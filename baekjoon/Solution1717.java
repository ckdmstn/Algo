import java.io.*;
import java.util.*;

public class Solution1717 {

	static int[] node;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		node = new int[n + 1];
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < node.length; i++) {
			node[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int flag = Integer.parseInt(st.nextToken());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			int min = Math.min(num1, num2);
			int max = Math.max(num1, num2);
			int parent = findParent(min);
			
			if (flag == 0) { // 합침 
				// 합치기
				combine(max, parent);
//				System.out.println(Arrays.toString(node));
			} else if (flag == 1) { // 포함 여부 확인
				int maxParent = findParent(max);
				
				if (parent == maxParent) {
					sb.append("YES").append("\n");
				} else {
					sb.append("NO").append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
	
	static int findParent(int current) {
		if (current == node[current]) {
			return current;
		}
		
		return node[current] = findParent(node[current]);
	}
	
	static void combine(int a, int b) {
		int rootA = findParent(a);
		int rootB = findParent(b);
		
		if (rootA == rootB) return;
		
		node[rootB] = rootA;
	}
 
}
