import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] arrSum = new int[N][N - 2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 2; j++) {
                arrSum[i][j] = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
            }
        }
        
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 2; j++) {
                for (int m = i; m < N; m++) {
                    int start = (i == m) ? j :0;
                    for (int n = start; n < N - 2; n++) {
                        if (i == m && j == n) continue;
                        if (i == m && n == j + 1) continue;
                        if (i == m && n == j + 2) continue;
                        
                        answer = Math.max(answer, arrSum[i][j] + arrSum[m][n]);
                    }
                }
            }
        }
        
        System.out.println(answer);
    }
}