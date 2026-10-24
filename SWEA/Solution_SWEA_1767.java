import java.util.*;
import java.io.*;

public class Solution_SWEA_1767 {

	static int N, maxCore, minLength;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static ArrayList<int[]> coreList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			coreList = new ArrayList<>();
			maxCore = 0; 
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if (map[i][j] == 1) {
						if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
							maxCore++;
						} else {
							coreList.add(new int[] {i, j});
						}
					}
				}
			}
			
			minLength = Integer.MAX_VALUE;
			
			func(0, maxCore, 0);
			
			sb.append("#").append(test_case).append(" ").append(minLength).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void func(int idx, int coreCount, int length) {
		if (coreList.size() == idx) {
			if (maxCore < coreCount) {
				maxCore = coreCount;
				minLength = length;
			} else if (maxCore == coreCount) {
				minLength = Math.min(minLength, length);
			}
			return;
		}
		
		int[] cur = coreList.get(idx);
		
		for (int d = 0; d < 5; d++) {
			if (d == 4) {
				func(idx + 1, coreCount, length);
			} else {
				int curLength = connectLength(cur[0], cur[1], d);
				
				if (curLength > 0) {
					connectWires(cur[0], cur[1], d, 2); // 연결
					func(idx + 1, coreCount + 1, length + curLength);
					connectWires(cur[0], cur[1], d, 0); // 연결 해제
				}
			}
		}
	}
	
	static int connectLength(int r, int c, int d) {
		int length = 0;
		
		while (true) {
			r += dr[d];
			c += dc[d];
			
			if (r < 0 || c < 0 || r >= N || c >= N) return length;
			if (map[r][c] == 1 || map[r][c] == 2) return 0;
			
			length++;
		}
	}
	
	static void connectWires(int r, int c, int d, int num) {
		while (true) {
			r += dr[d];
			c += dc[d];
			
			if (r < 0 || c < 0 || r >= N || c >= N) return;
			
			map[r][c] = num;
		}
	}

}
