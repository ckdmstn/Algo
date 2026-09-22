import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer = 0;
        
        Arrays.sort(B);
        for (int i = 0; i <= N - M; i++) {
            int[] copyA = Arrays.copyOfRange(A, i, i + M);
            Arrays.sort(copyA);
            
            boolean flag = true;
            for (int j = 0; j < M; j++) {
                if (copyA[j] != B[j]) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) answer++;
        }
        
        System.out.println(answer);
    }
}