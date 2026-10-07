import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST_Kruskal {

	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight) ; // 가중치 기준 오름차순
		}
	}
	
	static Edge[] edgeList;
	static int[] parents;
	static int V, E;
	
	
	static void makeSets() {
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) { // a가 속한 집합의 대표자 리턴
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]); // pass compression
	}
	
	static boolean union(int a,int b) { // a,b 가 속한 집합 합치기 
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false; // 이미 같은 집합이어서 합치기 실패
		parents[bRoot] = aRoot;
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parents = new int[V];
		edgeList = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		} // 간선리스트 생성
		
		Arrays.sort(edgeList);
		
		makeSets(); // 모든 정점을 루트로하는 트리로 만듦 
		int result = 0; // MST 비용
		int cnt = 0; // 사용된 간선수 
		for (Edge edge : edgeList) {
			if(union(edge.from, edge.to)) { // union 성공 :  두 트리가 서로 다른 트리였고 합치기 성공(싸이클이 발생하지 않음) 
				result += edge.weight;
				if(++cnt == V - 1) {
					break;
				}
			}
		}
		System.out.println(result);
	}

}









