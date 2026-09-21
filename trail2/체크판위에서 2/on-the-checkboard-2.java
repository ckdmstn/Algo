import java.util.*;
import java.io.*; 

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] area = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                area[i][j] = (st.nextToken().charAt(0) == 'W') ? 0 : 1;
                // W - 0 , B - 1
            }
        }
        
        int answer = 0;
        int cur = area[0][0];
        
        for (int i = 1; i < R - 1; i++) {
            int next = (cur == 0) ? 1 : 0;
            for (int j = 1; j < C - 1; j++) {
                if (area[i][j] == next) {
                    int next2 = (next == 0) ? 1 : 0;
                    for (int r = i + 1; r < R - 1; r++) {
                        for (int c = j + 1; c < C - 1; c++) {
                            if (area[r][c] == next2) {
                                int next3 = (next2 == 0) ? 1 : 0;
                                if (area[R - 1][C - 1] == next3) {
                                    answer++;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        System.out.println(answer);
    }
}