import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] grid = new char[N][N];
        int[] dr = {0, 1, 0, -1}; // 우, 하, 좌, 상
        int[] dc = {1, 0, -1, 0};
        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }
        int K = Integer.parseInt(br.readLine());
        
        int r, c, dir;
        if (1 <= K && K <= N) { // 하
            r = 0; c = K - 1;
            dir = 1;
        } else if (N < K && K <= 2 * N) { // 좌
            r = K - N - 1; c = N - 1;
            dir = 2;
        } else if (2 * N < K && K <= 3 * N) { // 상
            r = N - 1; c = 3 * N - K;
            dir = 3;
        } else { // 우
            r = 4 * N - K; c = 0;
            dir = 0;
        }
        
        int answer = 0;
        while (r >= 0 && c >= 0 && r < N && c < N) {
            if (dir == 0) { // 우
                if (grid[r][c] == '/') dir = 3;
                else dir = 1;
            } else if (dir == 1) { // 하
                if (grid[r][c] == '/') dir = 2;
                else dir = 0;
            } else if (dir == 2) { // 좌
                if (grid[r][c] == '/') dir = 1;
                else dir = 3;
            } else { // 상
                if (grid[r][c] == '/') dir = 0;
                else dir = 2;
            }
            
            r += dr[dir];
            c += dc[dir];
            
            answer++;
        }
        
        System.out.println(answer);
    }
}