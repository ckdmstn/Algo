import java.io.*;
import java.util.*;

public class Solution_SWEA_1873 {

	static char[][] map;
	static int[] dr = {-1, 0, 1, 0}; // U, L, D, R
	static int[] dc = {0, -1, 0, 1};
	static int H, W;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			
			int d = -1;
			int r = -1, c = -1;
			for (int i = 0; i < H; i++) {
				char[] chs = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					map[i][j] = chs[j];
					if (map[i][j] == '^') d = 0;
					else if (map[i][j] == '<') d = 1;
					else if (map[i][j] == 'v') d= 2; 
					else if (map[i][j] == '>') d = 3;
					if (map[i][j] == '^' || map[i][j] == '<' || map[i][j] == 'v' || map[i][j] == '>') {
						r = i;
						c = j;
						map[i][j] = '.';
					}
					
				}
				//   . 평지  / * 벽돌 벽 (파괴O) / # 강철 벽 / - 물
			}
			
			int N = Integer.parseInt(br.readLine());
			char[] userInput = br.readLine().toCharArray(); // UDLR, S(슛)
			
			
			for (int i = 0; i < userInput.length; i++) {
				if (userInput[i] == 'S') {
					shoot(r, c, d);
				} else {
					if (userInput[i] == 'U') d = 0;
					else if (userInput[i] == 'L') d = 1;
					else if (userInput[i] == 'D') d= 2; 
					else if (userInput[i] == 'R') d = 3;
					
					if (isMoveValid(r + dr[d], c + dc[d])) {
						r += dr[d];
						c += dc[d];
					}
				}
			}
			
			sb.append("#").append(test_case).append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (i == r && j == c) {
						if (d == 0) sb.append("^");
						else if (d == 1) sb.append("<");
						else if (d == 2) sb.append("v");
						else if (d == 3) sb.append(">");
					} else {
						sb.append(map[i][j]);
					}
				} sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	static boolean isMoveValid(int r, int c) {
		return (r >= 0 && c >= 0 && r < H && c < W 
				&& map[r][c] != '#' && map[r][c] != '-' && map[r][c] != '*');
	}
	
	static void shoot(int r, int c, int d) {
		while (true) {
			r += dr[d];
			c += dc[d];
			
			if (r < 0 || c < 0 || r >= H || c >= W) break;
			
			if (map[r][c] == '*') {
				map[r][c] = '.';
				break;
			} else if (map[r][c] == '.' || map[r][c] == '-') {
				continue;
			} else if (map[r][c] == '#') {
				break;
			}
		}
	}
	
}
