import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'L') {
                    for (int d = 0; d < 8; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                        if (arr[nr][nc] != 'E') continue;
                        
                        nr += dr[d];
                        nc += dc[d];
                        if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                        if (arr[nr][nc] != 'E') continue;
                        
                        answer++;
                    }
                }
            }
        }
        
        System.out.println(answer);
    }
}