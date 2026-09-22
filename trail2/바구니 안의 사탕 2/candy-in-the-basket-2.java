import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] candies = new int[N];
        int[] positions = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            candies[i] = Integer.parseInt(st.nextToken());
            positions[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer = 0;
        for (int i = -K; i <= 100; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if (i <= positions[j] && positions[j] <= i + 2 * K) {
                    sum += candies[j];
                }
            }
            
            answer = Math.max(answer, sum);
        }
        
        System.out.println(answer);
    }
}
