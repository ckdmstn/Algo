import java.io.*;
import java.util.StringTokenizer;

public class Solution3109 {

	static int R;
	static int C;
	static int[][] area;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		area = new int[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				area[i][j] = (ch[j] == '.') ? 0 : 1;
			}
		}
		
		int answer = 0;
		for (int i = 0; i < R; i++) {
			visited[i][0] = true;
			answer += (dfs(i, 0)) ? 1 : 0;
		}
		
		System.out.println(answer);
	}

	static boolean dfs(int r, int c) {
		if (c == C - 1) {
			return true;
		}
		
		for (int d = 0; d < 3; d++) {
			int nr = r + dr[d];
			
			if (nr >= 0 && nr < R && !visited[nr][c + 1] && area[nr][c + 1] == 0) {
				visited[nr][c + 1] = true;
				
				if (dfs(nr, c + 1)) {
					return true;
				}
			}
		}
		
		return false;
	}
}
