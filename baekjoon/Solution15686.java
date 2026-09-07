import java.io.*;
import java.util.*;

public class Solution15686 {

	static int N, M;
	static int[][] area;
	static ArrayList<int[]> chickenList;
	static ArrayList<int[]> selectedChicken;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 치킨 집의 최대 개수
		area = new int[N][N];
		chickenList = new ArrayList<>();
		selectedChicken = new ArrayList<>();
		answer = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {  
				area[i][j] = Integer.parseInt(st.nextToken());
				if (area[i][j] == 2) {
					chickenList.add(new int[] {i, j});
				}
			}
		}
		
		combi(0, 0);
		
		System.out.println(answer);
	}
	
	static void combi(int cnt, int start) {
		if (cnt == M) {
			// 거리 최솟값 구하기
			answer = Math.min(answer, calcDistance()); // 추후 수정
			return;
		}
		
		for (int i = start; i <  chickenList.size(); i++) {
			int[] select = chickenList.get(i);
			selectedChicken.add(select);
			combi(cnt + 1, i + 1);
			selectedChicken.remove(select);
		}
	}
	
	static int calcDistance() {
		int distanceSum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (area[i][j] == 1) {
					int min = Integer.MAX_VALUE;
					// 치킨 집과의 거리 중 최소
					for (int[] chicken : selectedChicken) {
						int distance = Math.abs(i - chicken[0]) + Math.abs(j - chicken[1]);
						min = Math.min(min, distance);
					}
					distanceSum += min;
				}
			} 
		} 
		
		return distanceSum;
	}

}
