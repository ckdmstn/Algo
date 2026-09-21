import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        int[][] arr = new int[n][m];

        int num = 1, r = 0, c = 0, d = 0;
        int max = n * m;
        while (num <= max) {
            arr[r][c] = num++;
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr >= n || nc >= m || arr[nr][nc] != 0) {
                d = (d + 1) % 4;
            }

            r += dr[d];
            c += dc[d];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            } sb.append("\n");
        }

        System.out.println(sb);
    }
}