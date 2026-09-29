import java.util.*;
import java.io.*;

public class Main {
    static class NumberLine implements Comparable<NumberLine> {
        int x, y;
        
        public NumberLine(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(NumberLine o) {
            return this.y - o.y;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        NumberLine[] nl = new NumberLine[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nl[i] = new NumberLine(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(nl);

        int answer = N;
        boolean[] con = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            boolean flag = false;
            for (int j = i + 1; j < N; j++) {
                if (nl[i].x > nl[j].x) {
                    flag = true;
                    if(!con[j]) {
                        con[j] = true;
                        answer--;
                    }
                }
            }

            if (flag && !con[i]) answer--;
        }

        System.out.println(answer);
    }
}