import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] x = new int[1001];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            x[Integer.parseInt(st.nextToken())] = (c == 'S') ? 1 : 2; // S : 1, N : 2 
        }

        int answer = 0;

        for (int i = a; i <= b; i++) {
            // 왼쪽 S, N 가까운 것 찾기
            int leftS = Integer.MAX_VALUE, leftN = Integer.MAX_VALUE;
            for (int j = i; j >= 0; j--) {
                if (leftS == Integer.MAX_VALUE && x[j] == 1) leftS = j;
                if (leftN == Integer.MAX_VALUE && x[j] == 2) leftN = j;
                if (leftN != Integer.MAX_VALUE && leftS != Integer.MAX_VALUE) break;
            }

            // 오른쪽 S, N 가까운 것 찾기
            int rightS = Integer.MAX_VALUE, rightN = Integer.MAX_VALUE;
            for (int j = i; j < 1001; j++) {
                if (rightS == Integer.MAX_VALUE && x[j] == 1) rightS = j;
                if (rightN == Integer.MAX_VALUE && x[j] == 2) rightN = j;
                if (rightN != Integer.MAX_VALUE && rightS != Integer.MAX_VALUE) break;
            }

            int d1 = Math.min(Math.abs(i - leftS), Math.abs(i - rightS));
            int d2 = Math.min(Math.abs(i - leftN), Math.abs(i - rightN));

            if (d1 <= d2) answer++;
        }
        
        System.out.println(answer);
    }
}
