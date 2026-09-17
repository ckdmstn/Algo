import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[201];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            for (int j = start; j < end; j++) {
                num[j + 100]++;
            }
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++) {
            max = Math.max(num[i], max);
        }
        
        System.out.println(max);
    }
}