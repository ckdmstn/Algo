import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] x = new char[101];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            char ch = st.nextToken().charAt(0);
            x[idx] = ch;
        }
        int[] positions = new int[N];
        char[] ch = new char[N];
        for (int i = 0, j = 0; j < x.length; j++) {
            if (x[j] == '\0') continue;
            ch[i] = x[j];
            positions[i++] = j;
        }
        
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int countG = 0, countH = 0;
            if (ch[i] == 'G') countG++;
            else countH++;
            
            for (int j = i + 1; j < N; j++) {
                if (ch[j] == 'G') countG++;
                else countH++;
                
                if (countG == countH || countH == 0 || countG == 0) {
                    answer = Math.max(answer, (positions[j] - positions[i]));
                }
            }
        }
        
        System.out.println(answer);
    }
}
