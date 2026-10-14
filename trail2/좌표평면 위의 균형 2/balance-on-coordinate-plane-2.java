import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer = Integer.MAX_VALUE;
        for (int i = 2; i <= 100; i += 2) {
            for (int j = 2; j <= 100; j += 2) {
                int[] count = new int[4];
                for (int k = 0; k < N; k++) {
                    if (i > x[k] && j > y[k]) {
                        count[0]++;
                    } else if (i < x[k] && j > y[k]) {
                        count[1]++;
                    } else if (i > x[k] && j < y[k]) {
                        count[2]++;
                    } else {
                        count[3]++;
                    }
                }

                int max = count[0];
                for (int k = 1; k < 4; k++) {
                    max = Math.max(max, count[k]);
                }

                answer = Math.min(answer, max);
            }
        }

        System.out.println(answer);
    }
}