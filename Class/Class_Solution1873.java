import java.io.*;
import java.util.*;

public class Class_Solution1873 {

	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	static final String TANK_SYMBOLS = "^>v<";
	static final String DIRS = "URDL"; // up, right, down, left
	
	static int H, W, r, c, dir;
	static char[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][];
			r = c = dir = 0;
			
			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			br.readLine();
			char[] command = br.readLine().toCharArray();
			
			play(command);
			
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				} sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}

	private static void play(char[] command) {
		LOOP: for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				dir = TANK_SYMBOLS.indexOf(map[i][j]);
				if (dir == -1) continue;
				
				r = i;
				c = j;
				break LOOP;
			}
		}
	
		map[r][c] = '.';
		for (char cm : command) {
			if (cm == 'S')
				shoot();
			else
				move(cm);
		}
		
		map[r][c] = TANK_SYMBOLS.charAt(dir);
	}
	
	private static void shoot() {
		int nr = r;
		int nc = c;
		
		while (true) {
			nr += dr[dir];
			nc += dc[dir];
			if (!isInRange(nr, nc) || map[nr][nc] == '#') break;
			
			if (map[nr][nc] == '*') {
				map[nr][nc] = '.';
				break;
			}
		}
	}
	
	private static void move(char newDir) {
		dir = DIRS.indexOf(newDir);
		
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		if (!isInRange(nr, nc) || map[nr][nc] != '.') return;
		
		r = nr;
		c = nc;
	}
	
	private static boolean isInRange(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}
 }
