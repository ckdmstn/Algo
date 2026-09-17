import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] countW = new int[200_001];
        int[] countB = new int[200_001];
        char[] lastColor = new char[200_001];
        
        int idx = 100_000;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            
            for (int j = 1; j <= count; j++) {
                if (dir.equals("R")) {
                    countB[idx]++;
                    lastColor[idx] = 'B';
                    if (j != count) idx++;
                } else {
                    countW[idx]++;
                    lastColor[idx] = 'W';
                    if (j != count) idx--;
                }
            }
        }
        
        int sumW = 0, sumB = 0, sumG = 0;
        for (int i = 0; i < countW.length; i++) {
            if (countW[i] >= 2 && countB[i] >= 2) sumG++;
            else if (lastColor[i] == 'B') sumB++;
            else if (lastColor[i] == 'W') sumW++;
        }
        
        System.out.println(sumW + " " + sumB + " " + sumG);
    }
}