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
        for (int drop = 1; drop < N - 1; drop++) {
            int distance = 0;
            for (int i = 0; i < N - 1; i++) {
                if (i + 1 == drop) continue;
                if (i == drop) {
                    distance += Math.abs(x[i - 1] - x[i + 1]) + Math.abs(y[i - 1] - y[i + 1]);
                } else {
                    distance += Math.abs(x[i] - x[i + 1]) + Math.abs(y[i] - y[i + 1]);
                }
            }
            
            answer = Math.min(distance, answer);
        }
        
        System.out.println(answer);
    }
}