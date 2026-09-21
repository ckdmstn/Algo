import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        int r = n / 2, c = n / 2, d = 3;
        int[] dr = {0, -1, 0, 1};
        int[] dc = {1, 0, -1, 0};
        int[][] arr = new int[n][n];

        int num = 1;
        int max = n * n;
        while (num <= max) {
            arr[r][c] = num++;
            
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if (nr < 0 || nc < 0  || nr >= n || nc >= n || arr[r + dr[(d + 1) % 4]][c + dc[(d + 1) % 4]] == 0) {
                d = (d + 1) % 4;
            }

            r += dr[d];
            c += dc[d];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]).append(" ");
            } sb.append("\n");
        }

        System.out.print(sb);
    }
}