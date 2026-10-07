import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST_Prim {

	static int V, E;
	static Node[] adjList;
	static boolean[] visited;
	static int[] minEdge;
	
	static class Node{
		int to, weight;
		Node next;
		
		public Node(int to, int weight, Node next) {
			super();
			this.to = to;
			this.weight = weight;
			this.next = next;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adjList = new Node[V];
		visited = new boolean[V];
		minEdge = new int[V];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
	
			// 간선 양방향 처리
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		} // 인접리스트 생성
		
		// minEdge 'inf'값으로 초기화
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		int result = 0 ; //mst 	비용
		
		// 임의의 시작정점 선택해서 minEdge 0 처리 
		minEdge[0] = 0;
		
		int c;
		for (c = 0; c < V; c++) {
			// step1. 비트리 정점중 최소간선비용의 정점 찾기
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			
			for (int i = 0; i < V; i++) {
				if(!visited[i] && minEdge[i] < min) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			
			if(minVertex == -1) break;
			result += min;
			visited[minVertex] = true;  // 트리에 속한 정점으로 만들기 
			
			// step2. 선택된 정점의 인접정점들(비트리 정점들)과의 간선비용 비교해서  minEgde 갱신 작업
			for (Node temp = adjList[minVertex]; temp != null; temp = temp.next) {
				if(!visited[temp.to] && minEdge[temp.to] > temp.weight) { // 기존 최소 간선비용보다  minVertex와의 연결이 유리하다면 갱신
					minEdge[temp.to] = temp.weight;
				}
			}
		}
		
		System.out.println(c == V ? result : -1);
	}

}









