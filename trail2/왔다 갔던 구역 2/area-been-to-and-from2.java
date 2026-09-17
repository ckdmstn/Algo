import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] num = new int[2001];
        int current = 1000;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            
            for (int j = 0; j < count; j++) {
                if (dir.equals("R")) {
                    num[current++]++;
                } else {
                    num[--current]++;
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] >= 2) {
                answer++;
            }
        }
        
        System.out.println(answer);
    }
}