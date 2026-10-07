import java.util.*;
import java.io.*;

public class Dijkstra {

	static class Node {
		int to, weight;
		Node next;
		
		public Node(int to, int weight, Node next) {
			this.to = to;
			this.weight = weight;
			this.next = next;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		final int INF = Integer.MAX_VALUE;
		Node[] adjList = new Node[V];
		int[] minDist = new int[V]; // 출발지에서 각 정점까지의 최단거리 (최소비용)
		boolean[] visited = new boolean[V];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, weight, adjList[from]);
		}
		
		Arrays.fill(minDist, INF);
		minDist[start] = 0;
		
		for (int i = 0; i < V; i++) {
			// step1. 미방문 정점 중 출발점에서의 최단거리 정점 선택
			int min = INF;
			int cur = -1;
			
			for (int j = 0; j < V; j++) {
				if (!visited[j] && min > minDist[j]) {
					min = minDist[j];
					cur = j;
				}
			}
			
			if (cur == -1) break;
			
			visited[cur] = true; // 방문
			if (cur == end) break;
			
			// step2. 선택된 정점을 경유지로 하여 미방문 인접 정점들의 최단거리 비용과 비교하여 최소값 갱신
			
			for (Node temp = adjList[cur]; temp != null; temp = temp.next ) {
				if (!visited[temp.to] && minDist[temp.to] > min + temp.weight) {
					minDist[temp.to] = min + temp.weight;
				}
			}
		}
		
		System.out.println(minDist[end] != INF ? minDist[end] : -1);
		System.out.println(Arrays.toString(minDist));
	}

}
