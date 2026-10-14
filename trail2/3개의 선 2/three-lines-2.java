import java.util.*;
import java.io.*;

public class Main {
    
    static int N;
    static int[] x, y;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        x = new int[N];
        y = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i <= 19; i++) {
            for (int j = i + 1; j <= 20; j++) {
                for (int k = j + 1; k <= 21; k++) {
                    if (isPassedByLine(new int[] {i, j, k})) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }

    static boolean isPassedByLine(int[] n) {
        boolean isPassedByLine = true;

        for (int i = 0; i < N; i++) {
            boolean flag = false;
            for (int j = 0; j < 3; j++) {
                if (n[j] <= 10) { // 가로
                    if (y[i] == n[j]) flag = true;
                } else { // 세로
                    if (x[i] == (n[j] - 11)) flag = true;
                }
            }

            if (!flag) {
                isPassedByLine = false;
                break;
            }
        }

        return isPassedByLine;
    }
    
}